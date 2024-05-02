package gui;

import model.Caixa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMovimento extends JFrame implements ActionListener {
    //Atributos da janela
    private Label lblValor, lblSaldo;
    private TextField txtValor, txtSaldo;
    private Button cmdEntrada, cmdRetirada, cmdConsulta, cmdSair;
    private TextArea txtMsg;
    private Dimension dLabel, dTextField, dButton, dFrame, dTextArea;
    private Caixa caixa;

    //Método construtor
    public TelaMovimento(){
        //Instanciar uma conta caixa
        caixa = new Caixa();
        //Aparência e comportamento da janela de movimento
        //definindo tamanhos
        dFrame = new Dimension(350, 400);
        dLabel = new Dimension(40,20);
        dTextField = new Dimension(150,20);
        dButton = new Dimension(95,20);
        dTextArea = new Dimension(300, 140);
        //definir aparencia do Frame (janela)
        setSize(dFrame);
        setTitle("Controle de Caixa");
        setLocationRelativeTo(null);//centraliza a janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //clicar no X fecha o programa
        setLayout(null); //nulo significa que indicaremos as posições do componentes
        //Adicionando componentes
        lblValor = new Label("Valor: ");
        lblValor.setSize(dLabel);
        lblValor.setLocation(25,50);
        add(lblValor); //colocou o componente na janela

        lblSaldo = new Label("Saldo:");
        lblSaldo.setSize(dLabel);
        lblSaldo.setLocation(25,80);
        add(lblSaldo);

        txtValor = new TextField(null);
        txtValor.setSize(dTextField);
        txtValor.setLocation(75,50);
        add(txtValor);

        txtSaldo = new TextField(null);
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75, 80);
        add(txtSaldo);

        cmdEntrada = new Button("Entrada");
        cmdEntrada.setSize(dButton);
        cmdEntrada.setLocation(25,150);
        cmdEntrada.addActionListener(this);
        add(cmdEntrada);

        cmdRetirada = new Button("Retirada");
        cmdRetirada.setSize(dButton);
        cmdRetirada.setLocation(225,150);
        cmdRetirada.addActionListener(this);
        add(cmdRetirada);

        cmdConsulta = new Button("Consulta");
        cmdConsulta.setSize(dButton);
        cmdConsulta.setLocation(25,185);
        cmdConsulta.addActionListener(this);
        add(cmdConsulta);

        cmdSair = new Button("Saída");
        cmdSair.setSize(dButton);
        cmdSair.setLocation(225,185);
        cmdSair.addActionListener(this);
        add(cmdSair);

        txtMsg = new TextArea(null);
        txtMsg.setSize(dTextArea);
        txtMsg.setLocation(25,220);
        add(txtMsg);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmdSair){
            System.exit(0);
        }
        if(e.getSource()==cmdEntrada){
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
            return;
        }
        if(e.getSource()==cmdConsulta){
            txtSaldo.setText(Double.toString(caixa.getSaldo()));
            txtMsg.append("Saldo no momento: " + txtSaldo.getText());
            txtMsg.append("\n");
        }
        if(e.getSource()==cmdRetirada){
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
    }
}