package exceptions;

public class MemberNotFoundException extends BidBlitzException{

    public MemberNotFoundException(){
        super("Member did not register for this event");
    }
}
