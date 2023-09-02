package exceptions;

public class TiedResultException extends BidBlitzException{

    public TiedResultException(){
        super("Two or more members won the event with id ");
    }
}
