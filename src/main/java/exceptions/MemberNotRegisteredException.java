package exceptions;

public class MemberNotRegisteredException extends BidBlitzException {

    public MemberNotRegisteredException(){
        super("Member did not register for this event");
    }
}
