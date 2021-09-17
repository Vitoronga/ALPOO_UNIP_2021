package Model;

public class Tecnico {
    private String nome;
    private double salario;
    private String cargo;
    private String departamento;

    public Tecnico(String nome, double salario, String cargo, String departamento) {
        this.setNome(nome);
        this.setSalario(salario);
        this.setCargo(cargo);
        this.setDepartamento(departamento);
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
        
        ret += "Nome........: " + this.getNome() +
             "\nSalário.....: " + this.getSalario() +
             "\nCargo.......: " + this.getCargo() +
             "\nDepartamento: " + this.getDepartamento();
        
        return ret;
    }
}
