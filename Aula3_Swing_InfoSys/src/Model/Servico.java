package Model;

import DAO.ServicoDAO;

public class Servico {
    private int codigo = 0;
    private String nome;
    private String servico;
    private double valor;
    
    // depois dá pra fazer isso relacionado com as tabelas clientes e técnicos do bd
    
    public Servico(String n, String s, double v) {
        this.setNome(n);
        this.setServico(s);
        this.setValor(v);
        
        this.gravar();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        String ret;
        
        ret = "Codigo....: " + this.getCodigo() + "\n" +
              "Nome....: " + this.getNome() + "\n" +
              "Serviço.: " + this.getServico() + "\n" + 
              "Valor...: " + this.getValor() + "\n";
        
        return ret;
    }
    
    private void gravar() {
        ServicoDAO dao = new ServicoDAO();
        int cod = dao.create(this);
        
        if(cod > 0) this.setCodigo(cod);
    }
}
