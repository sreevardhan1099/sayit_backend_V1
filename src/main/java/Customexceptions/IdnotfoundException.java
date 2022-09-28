package Customexceptions;

public class IdnotfoundException extends RuntimeException{

    String message;
    private static final long serialVersionUID = 1L;

    public IdnotfoundException(){


    }
    public IdnotfoundException(final String message) {

        super(message);


    }
//    public IdnotfoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
}
