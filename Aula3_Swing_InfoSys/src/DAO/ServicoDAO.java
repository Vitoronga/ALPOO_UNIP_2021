package DAO;

import Model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ServicoDAO implements Persistencia<Servico>{
    private static ServicoDAO dao = null;
    
    public ServicoDAO() {
        
    }
    
    public static ServicoDAO getInstance() {
        if (dao == null) dao = new ServicoDAO();
        return dao;
    }
    
    @Override
    public int create(Servico s) {
        int id = 0;
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Servicos (Nome, Servico, Valor) VALUES (?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, s.getNome());
            pst.setString(2, s.getServico());
            pst.setDouble(3, s.getValor());
            
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

    @Override
    public Servico findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Servico obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Servico> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
