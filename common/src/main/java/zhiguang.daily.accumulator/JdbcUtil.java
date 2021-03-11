package zhiguang.daily.accumulator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class JdbcUtil {

    /**
     * 数据包装类型——封装成map形式(key-value)
     */
    private static final String AS_MAP = "map";

    /**
     * 数据包装类型——封装成list形式
     */
    private static final String AS_LIST = "list";



    /**
     * 解析jdbc为host port dbName 按顺序存储到list中
     * @param jdbcUrl
     * @return List<String>
     */
    public static List<String> parseJdbcUrlAsList(String jdbcUrl) {
        List<String> list = new ArrayList<>(3);
        if (jdbcUrl != null) {
            String[] split = jdbcUrl.split(":");
            list.add(split[0]);
            String[] split1 = split[1].split("/");
            list.add(split1[0]);
            list.add(split1[1]);
        }
        return list;
    }



    /**
     * 获取数据库连接
     * @param driver
     * @param jdbcUrl
     * @param username
     * @param password
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection(String driver, String jdbcUrl, String username, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName(driver);
//        log.info("当前连接串：{}, {}", jdbcUrl, username);
        return DriverManager.getConnection(jdbcUrl, username, password);
    }



    /**
     * ddl操作 返回成功与否
     * @param dbType
     * @param connection
     * @param command
     * @return boolean sql执行成功则返回true 失败则为false
     * @throws SQLException
     */
    public static boolean execute(String dbType, Connection connection, String command) throws SQLException {

        if (connection == null) {
            throw new NullPointerException("connection is null, execute sql failed");
        }

        if (StringUtils.isBlank(command)) {
            throw new NullPointerException("command is null, execute sql failed");
        }
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(command);
            //若为mysql数据源 设置超时时间 5分钟
            if (DbType.MYSQL.getOfficialName().equalsIgnoreCase(dbType)) {
                statement.setQueryTimeout(5 * 60);
            }
            return statement.execute();

        } finally {
            closeResource(null, statement, connection);
        }

    }


    /**
     * executeQuery
     * @param dbType
     * @param connection
     * @param command
     * @param columns
     * @param style   目前支持 list / map 或者为空 表示不需要返回结果
     * @return Object 根据选择包装的类型返回对应的情况 若不需要返回数据则返回null
     * @throws SQLException
     */
    public static Object executeQuery(String dbType, Connection connection, String command, Integer columns, String style)
            throws SQLException {
        if (connection == null) {
            throw new NullPointerException("connection is null, execute sql failed");
        }
        if (StringUtils.isBlank(command)) {
            throw new NullPointerException("command is null, execute sql failed");
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            log.info("执行SQL: {}",command);
             statement = connection.prepareStatement(command);
            //若为mysql数据源 设置超时时间 5分钟
            if (DbType.MYSQL.getOfficialName().equalsIgnoreCase(dbType)) {
                statement.setQueryTimeout(5 * 60);
            }
            resultSet = statement.executeQuery();
            //若后期存在多种封装情况 可进行抽离出去
            switch (style) {
                case AS_LIST :
                    return wrapDataAsList(resultSet, columns);
                case AS_MAP :
                    return wrapDataAsMap(resultSet, columns);
                default:
                    //若style为空的时候 证明不需要返回数据 则返回null即可
                    return null;
            }
        } finally {
            closeResource(resultSet, statement, connection);
        }

    }


    /**
     * 封装数据成list
     * @param resultSet
     * @param columns
     * @return List<String>
     * @throws SQLException
     */
    private static List<String> wrapDataAsList(ResultSet resultSet, Integer columns) throws SQLException {
        if (resultSet == null) {
            throw new NullPointerException("resultSet is null, wrap data as list failed");
        }
        List<String> dataList = new ArrayList<>(16);
        while (resultSet.next()) {
            for (int i = 1; i <= columns; i++) {
                if (resultSet.getString(i) != null) {
                    dataList.add(resultSet.getString(i));
                } else {
                    dataList.add("0");
                }
            }
        }
        return dataList;
    }

    /**
     * 封装数据成map
     * 理论上 columns应该是2 但是如果大于2的话则用 #分割
     * 例如:
     * key = a
     * value = b#c
     * @param resultSet
     * @param columns
     * @return Map<String, String>
     */
    private static Map<String, String> wrapDataAsMap(ResultSet resultSet, Integer columns) throws SQLException {
        if (resultSet == null) {
            throw new NullPointerException("resultSet is null, wrap data as list failed");
        }
        Map<String, String> dataMap = new HashMap<>(16);
        while (resultSet.next()) {
            List<String> dataList = new ArrayList<>(6);
            for (int i = 1; i <= columns; i++) {
                if (resultSet.getString(i) != null) {
                    dataList.add(resultSet.getString(i));
                } else {
                    dataList.add("0");
                }
            }
            StringBuilder valueBuilder = new StringBuilder();
            for (int i = 1; i < dataList.size(); i++) {
                valueBuilder.append(dataList.get(i)).append("#");
            }
            log.info("key:{},  value:{}", dataList.get(0), valueBuilder.substring(0, valueBuilder.length() - 1));
            dataMap.put(dataList.get(0), valueBuilder.substring(0, valueBuilder.length() - 1));
        }
        return dataMap;
    }




    /**
     * 资源的释放
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.error("释放resultSet失败:{}", e.getMessage());
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error("释放statement失败:{}", e.getMessage());
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("释放connection失败:{}", e.getMessage());
            }
        }
    }

    /**
     * 资源的释放
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeResource2(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.error("释放resultSet失败:{}", e.getMessage());
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error("释放statement失败:{}", e.getMessage());
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("释放connection失败:{}", e.getMessage());
            }
        }
    }


}
