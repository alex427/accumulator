package zhiguang.daily.accumulator.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * 数据库类型
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DbType {
    /**
     * 数据库类型
     */
    MYSQL("com.mysql.jdbc.Driver", "mysqlreader", "mysql"),

    POSTGRESQL("org.postgresql.Driver", "postgresqlreader", "postgresql"),

    ORACLE("oracle.jdbc.OracleDriver", "oraclereader", "oracle"),

    SAP("com.sap.db.jdbc.Driver", "sapreader", "sap"),

    HIVE("org.apache.hive.jdbc.HiveDriver", "hivereader", "hive"),

    SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver","sqlserverreader","sqlserver"),

    KUDU("", "kudureader", "kudu"),

    FTP("", "ftpreader", "ftp"),

    MONGODB("","mongodbreader","mongodb");

    private String driver;

    private String readerName;

    private String officialName;


    /**
     * 根据officeName获取DbType
     * @param officialName
     * @return DbType
     */
    public static DbType valueOfOfficeName(String officialName) {
         return Arrays.stream(DbType.values())
                 .filter(dbType -> dbType.officialName.equalsIgnoreCase(officialName))
                 .findFirst()
                 .orElseThrow(() -> new RuntimeException("not match officeName: " + officialName + " dbType"));

    }


}
