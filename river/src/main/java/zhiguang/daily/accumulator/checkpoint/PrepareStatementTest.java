package zhiguang.daily.accumulator.checkpoint;

import lombok.extern.slf4j.Slf4j;
import zhiguang.daily.accumulator.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class PrepareStatementTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String code = "rows";
        Class.forName("com.mysql.jdbc.Driver");
        String username = "root";
        String password = "123456789";
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/water_drop" , username, password);

        if (conn == null) {
            log.error("获取连接Connection返回空");
        }
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<String> data = new ArrayList<>(1);
        String r = null;
        //String command = "show table status like \"" + tableName + "\"";
        String tableName = "user_order";
        try {
            log.info("执行命令: show table status like \"{}\" ", tableName);
            pstmt = conn.prepareStatement("show table status like ? ");
            pstmt.setString(1, tableName);
            resultSet = pstmt.executeQuery();

            String ROWS = "rows";
            String DATA_LENGTH = "data_length";
            if(ROWS.equals(code)) {
                while (resultSet.next()) {
                    r = resultSet.getString(5);
                }
            } else if(DATA_LENGTH.equals(code)) {
                while (resultSet.next()) {
                    r = resultSet.getString(7);
                }
            }
            data.add(r);
            System.out.println(data);

            //return data;
        } finally {
            //释放资源
            JdbcUtil.closeResource2(resultSet, pstmt, conn);
        }


    }

}
