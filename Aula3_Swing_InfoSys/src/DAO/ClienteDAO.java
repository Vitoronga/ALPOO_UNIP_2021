package DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements Persistencia<Cliente>{
    private static ClienteDAO dao = null;
    
    public ClienteDAO() {
        
    }
    
    public static ClienteDAO getInstance() {
        if (dao == null) dao = new ClienteDAO();
        return dao;
    }
    
    @Override
    public int create(Cliente c) {
        int id = 0;
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Clientes (Nome, CPF, Fone, Celular, Email) VALUES (?, ?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCpf());
            pst.setString(3, c.getFone());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());           
            
            pst.execute();
            rs = pst.getGeneratedKeys();
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            id = 0;
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        
        return id;
    }
}
