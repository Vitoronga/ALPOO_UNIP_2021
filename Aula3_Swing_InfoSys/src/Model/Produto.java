package Model;

import DAO.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Produto {
    private int codigo = 0;
    private String descricao = null;
    private int estoque;
    private boolean ativo = false;
    private double custo = 0;
    private double valor = 0;

    public Produto() {
        
    }
    
    public Produto(int cod, String d, Boolean a, int e, double c, double v) {
        this.setCodigo(cod);
        this.setDescricao(d);
        this.setAtivo(a);
        this.setEstoque(e);
        this.setCusto(c);
        this.setValor(v);
    }
    
    public Produto(String d, int e, double c, double v) {
        this.setDescricao(d);
        this.setEstoque(e);
        this.setCusto(c);
        this.setValor(v);
        this.setAtivo(true);
        gravar();
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int cod) {
        this.codigo = cod;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    @Override
    public String toString() {
        String ret;
        
        if (isAtivo()) ret = "[Ativo] - ";
        else ret = "[Fora de Linha] - ";
        
        ret += "[Item: " + this.getDescricao() +
              "] - [Estoque: " + this.getEstoque() +
              "] - [Custo: " + this.getCusto() +
              "] - [Preço de Venda: " + this.getValor() + "]";
        
        return ret;
    }
    
    public void gravar() {
        ProdutoDAO dao = new ProdutoDAO();
        
        int cod = dao.create(this);
        if(cod > 0) this.setCodigo(cod);
    }
    
    public static DefaultTableModel getTableModel() {
        List<Produto> lista = ProdutoDAO.getInstance().read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Descricao");
        modelo.addColumn("Ativo");
        modelo.addColumn("Estoque");
        modelo.addColumn("Custo");
        modelo.addColumn("Valor");
        
        for (Produto p : lista) {
            String[] reg = {p.getDescricao(), String.valueOf(p.isAtivo()), String.valueOf(p.getEstoque()), 
                String.valueOf(p.getCusto()), String.valueOf(p.getValor())};
            modelo.addRow(reg);
        }
        
        return modelo;
    }
}
