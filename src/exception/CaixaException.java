package exception;

public class CaixaException extends Exception{
    private String codigoExcecao;

    public CaixaException(String codigoExcecao){
        this.codigoExcecao = codigoExcecao;
    }

    @Override
    public String getMessage() {
        String erro = "";
        if(codigoExcecao.equals("RF01EX01")){
            erro = "Valor inválido para o depósito";
        } else if (codigoExcecao.equals("RF01EX02")) {
            erro = "Sem saldo suficiente para o saque";
        }
        return erro;
    }
}