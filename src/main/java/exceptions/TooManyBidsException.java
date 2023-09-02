package exceptions;

public class TooManyBidsException extends BidBlitzException{

    public TooManyBidsException(){
        super("Only a maximum of 5 \"unique\" bids for a user per event are allowed");
    }
}
