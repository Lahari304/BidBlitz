package exceptions;

public class YoureBrokeException extends BidBlitzException{

    public YoureBrokeException(){
        super("Sorry, your bids can't be accepted. You're broke");
    }
}
