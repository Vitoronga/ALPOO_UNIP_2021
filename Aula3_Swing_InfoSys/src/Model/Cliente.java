package Model;

public class Cliente {
    private String nome = null; // talvez o null ajude pra retornar get vazio...
    private String cpf = null;
    private String fone = null;
    private String celular = null;
    private String email = null;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        String ret;
        
        ret = "Cliente.: [" + this.getNome() + "]\n" +
              "CPF.....: [" + this.getCpf() + "]\n" +
              "Telefone: [" + this.getFone() + "]\n" +
              "Celular.: [" + this.getCelular() + "]\n" +
              "Email...: [" + this.getEmail() + "]\n";
        
        return ret;
    }
}
