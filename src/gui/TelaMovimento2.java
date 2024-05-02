package gui;

import model.Caixa;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaMovimento2 {
    private JPanel painelCaixa;
    private JTextField txtValor;
    private JTextField txtSaldo;
    private JButton cmdEntrada;
    private JButton cmdRetirada;
    private JButton cmdConsulta;
    private JButton cmdSair;
    private JTextArea txtMsg;

    public JPanel getPainelCaixa() {
        return painelCaixa;
    }
    private Caixa caixa;

    public TelaMovimento2(){
        caixa = new Caixa();


        cmdEntrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    String resposta = null;
                    double vlr = Double.parseDouble(txtValor.getText());
                    resposta = caixa.depositar(vlr);

                    if(resposta!=null) {
                        txtMsg.append(resposta + "\n");
                        txtValor.setText(null);
                        txtValor.requestFocus(); //coloca o foco no controle
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });
        cmdConsulta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtSaldo.setText(Double.toString(caixa.getSaldo()));
                txtMsg.append("Saldo no momento: " + txtSaldo.getText());
                txtMsg.append("\n");

            }
        });
        cmdRetirada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    String resposta = null;
                    double vlr = Double.parseDouble(txtValor.getText());
                    resposta = caixa.sacar(vlr);

                    if(resposta!=null) {
                        txtMsg.append(resposta + "\n");
                        txtValor.setText(null);
                        txtValor.requestFocus(); //coloca o foco no controle
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            "Erro",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });


        cmdSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }
}