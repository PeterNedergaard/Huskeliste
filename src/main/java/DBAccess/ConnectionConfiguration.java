//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public ConnectionConfiguration() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/huskeliste?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "root";

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return connection;
    }
}
