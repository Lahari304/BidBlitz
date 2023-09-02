package exceptions;

public class DateNotAvailableException extends BidBlitzException{

    public DateNotAvailableException(){
        super("Sorry, this event can't be registered for the date ");
    }
}
