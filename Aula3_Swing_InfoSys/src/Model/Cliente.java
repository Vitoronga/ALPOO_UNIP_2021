package Model;

import DAO.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Cliente {
    private int codigo = 0;
    private String nome = null; // talvez o null ajude pra retornar get vazio...
    private String cpf = null;
    private String fone = null;
    private String celular = null;
    private String email = null;

    public Cliente() {
        
    }
    
    public Cliente(int codigo, String n, String cpf, String f, String cel, String e) {
        this.setCodigo(codigo);
        this.setNome(n);
        this.setCpf(cpf);
        this.setFone(f);
        this.setCelular(cel);
        this.setEmail(e);
    }
    
    public Cliente(String n, String cpf, String f, String cel, String e) {
        this.setNome(n);
        this.setCpf(cpf);
        this.setFone(f);
        this.setCelular(cel);
        this.setEmail(e);
        
        this.gravar();
    }
        /** Método Construtor recebendo os parâmetros nome, cpf, fone, celular e email
         * do tipo String e chamando os métodos sets dos mesmos
         * 
         * @return 
         */
    
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
        
        ret = "Código..: [" + this.getCodigo() + "]\n" +
              "Cliente.: [" + this.getNome() + "]\n" +
              "CPF.....: [" + this.getCpf() + "]\n" +
              "Telefone: [" + this.getFone() + "]\n" +
              "Celular.: [" + this.getCelular() + "]\n" +
              "Email...: [" + this.getEmail() + "]\n";
        
        return ret;
    }
    
    private void gravar() {
        ClienteDAO dao = new ClienteDAO();
        int cod = dao.create(this);
        
        if(cod > 0) this.setCodigo(cod);
    }
    
    public static DefaultTableModel getTableModel() {
        List<Cliente> lista = ClienteDAO.getInstance().read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
        modelo.addColumn("Email");
        
        for (Cliente c : lista) {
            String[] reg = {c.getNome(), c.getCpf(), c.getFone(), c.getCelular(), c.getEmail()};
            modelo.addRow(reg);
        }
        
        return modelo;
    }
}
