package insa.smart.smart_back.exception;

public class EmailExistsException extends RuntimeException{
    private  String message;

    public EmailExistsException(String message){
        this.message = message;
    }
    public EmailExistsException(){

    }
}
