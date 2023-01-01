package datos;

import org.apache.commons.dbcp2.BasicDataSource;
import org.jetbrains.annotations.NotNull;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    //Constantes URL:
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/to_do_list?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);

        ds.setInitialSize(5);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        return getDataSource().getConnection();
    }
    public static void close(@NotNull ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
