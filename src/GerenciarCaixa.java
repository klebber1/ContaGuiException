import gui.TelaMovimento;
import gui.TelaMovimento2;

import javax.swing.*;

public class GerenciarCaixa {
    public static void main(String[] args) {
        JFrame tela = new JFrame();
        /*
        tela.setContentPane(new TelaMovimento2().getPainelCaixa());
        tela.setVisible(true);
        tela.setTitle("Controle de Caixa");
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setSize(350,400);
        */
        TelaMovimento tela = new TelaMovimento();
        tela.setVisible(true);
    }
}
