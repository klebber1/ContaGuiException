package model;

import exception.CaixaException;

public class Caixa {
    private double saldo;

    public String depositar(double valor) throws CaixaException {
        if(valor > 0){
            saldo += valor;
            return "Depósito efetuado com sucesso";
        }
        throw new CaixaException("RF01EX01");
    }

    public String sacar(double valor) throws CaixaException {
        if(valor <= saldo){
            saldo -= valor;
            return "Saque efetuado com sucesso";
        }
        throw new CaixaException("RF01EX02");
    }

    public double getSaldo() {
        return saldo;
    }
}