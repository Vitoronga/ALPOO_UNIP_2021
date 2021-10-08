package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    private static final String URL = "jdbc:sqlite:C:\\Users\\vitor\\Documents\\GitHub\\ALPOO_UNIP_2021\\Aula3_Swing_InfoSys\\db\\InfoSysDB.db";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão");
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no fechamento da conexão");
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement pst) {
        try {
            if (pst != null) pst.close();
            closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException("Erro no fechamento do statement");
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            closeConnection(con, pst);
        } catch (SQLException e) {
            throw new RuntimeException("Erro no fechamento do result set");
        }
    }
}
