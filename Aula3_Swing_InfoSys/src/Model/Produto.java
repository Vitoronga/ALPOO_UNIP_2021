package Model;

public class Produto {
    private String descricao = null;
    private int estoque;
    private boolean ativo = false;
    private double valor = 0;
    private double custo = 0;

    public Produto(String d, int e, double v, double c) {
        this.setDescricao(d);
        this.setEstoque(e);
        this.setValor(v);
        this.setCusto(c);
        this.setAtivo(true);
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
}
