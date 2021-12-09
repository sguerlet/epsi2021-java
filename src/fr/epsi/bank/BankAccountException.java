package fr.epsi.bank;

public class BankAccountException extends Exception{
    
    private String message;

    public BankAccountException(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}
