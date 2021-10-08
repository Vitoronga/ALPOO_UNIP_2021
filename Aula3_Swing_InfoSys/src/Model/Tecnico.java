package Model;

import DAO.TecnicoDAO;

public class Tecnico {
    private int codigo = 0;
    private String nome;
    private double salario;
    private String cargo;
    private String departamento;

    public Tecnico(String nome, double salario, String cargo, String departamento) {
        this.setNome(nome);
        this.setSalario(salario);
        this.setCargo(cargo);
        this.setDepartamento(departamento);
        
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        String ret = "";
        
        ret += "Codigo......: " + this.getCodigo() +
             "\nNome........: " + this.getNome() +
             "\nSalário.....: " + this.getSalario() +
             "\nCargo.......: " + this.getCargo() +
             "\nDepartamento: " + this.getDepartamento();
        
        return ret;
    }
    
    private void gravar() {
        TecnicoDAO dao = new TecnicoDAO();
        int cod = dao.create(this);
        
        if(cod > 0) this.setCodigo(cod);
    }
}
