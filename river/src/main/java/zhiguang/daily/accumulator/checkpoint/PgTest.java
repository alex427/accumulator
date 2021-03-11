package zhiguang.daily.accumulator.checkpoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "localhost:5432";
        String username = "postgres";
        String password = "123456789";
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/water_drop" , username, password);

        Statement stmt = conn.createStatement();
/*        String sql = " select column_name, data_type from information_schema.columns where table_schema= " + "'public' and table_name='company' ";
        ResultSet resultSet =  stmt.executeQuery(sql);

        if (resultSet == null) {
            throw new NullPointerException("resultSet is null, wrap data as list failed");
        }
        List<String> dataList = new ArrayList<>(16);
        while (resultSet.next()) {
            for (int i = 1; i <= 2; i++) {
                if (resultSet.getString(i) != null) {
                    dataList.add(resultSet.getString(i));
                } else {
                    dataList.add("0");
                }
            }
        }

        System.out.println(dataList);*/


        String sql2 = "select count(1) as COUNT from company";
        ResultSet resultSet2 =   stmt.executeQuery(sql2);

        List<String> dataList2 = new ArrayList<>(16);
        while (resultSet2.next()) {
            for (int i = 1; i <= 1; i++) {
                if (resultSet2.getString(i) != null) {
                    dataList2.add(resultSet2.getString(i));
                } else {
                    dataList2.add("0");
                }
            }
        }

        System.out.println(dataList2);



//        resultSet.close();
        resultSet2.close();
        stmt.close();
        conn.close();

    }
}
