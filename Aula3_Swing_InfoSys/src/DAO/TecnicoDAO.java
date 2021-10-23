package DAO;

import Model.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TecnicoDAO implements Persistencia<Tecnico>{
    private static TecnicoDAO dao = null;
    
    public TecnicoDAO() {
        
    }
    
    public static TecnicoDAO getInstance() {
        if (dao == null) dao = new TecnicoDAO();
        return dao;
    }
    
    @Override
    public int create(Tecnico t) {
        int id = 0;
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Tecnicos (Nome, Salario, Cargo, Departamento) VALUES (?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, t.getNome());
            pst.setDouble(2, t.getSalario());
            pst.setString(3, t.getCargo());
            pst.setString(4, t.getDepartamento());        
            
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
    public Tecnico findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Tecnico obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
