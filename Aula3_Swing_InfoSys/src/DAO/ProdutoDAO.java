package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO implements Persistencia<Produto>{
    private static ProdutoDAO dao = null;
    
    public ProdutoDAO() {
        
    }
    
    public static ProdutoDAO getInstance() {
        if (dao == null) dao = new ProdutoDAO();
        return dao;
    }
    
    @Override
    public int create(Produto obj) {
        int id = 0;
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;        
        String sql = "INSERT INTO Produtos (Descricao, Ativo, Estoque, Custo, Valor) VALUES (?, ?, ?, ?, ?)";
        
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getDescricao());
            pst.setBoolean(2, obj.isAtivo());
            pst.setInt(3, obj.getEstoque());
            pst.setDouble(4, obj.getCusto());
            pst.setDouble(5, obj.getValor());
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
    public Produto findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
