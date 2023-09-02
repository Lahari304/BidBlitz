package exceptions;

public class EventNotFoundException extends BidBlitzException{

    public EventNotFoundException(){
        super("Event not fond with id ");
    }
}
