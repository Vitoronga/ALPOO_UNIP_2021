package Controller;

import Resources.Configura;
import View.TelaCadastro;

public class Principal {
    public static void main(String[] args) {
        Configura.lookAndFeel("Windows Classic");
        
        new TelaCadastro().setVisible(true);
    }
}
