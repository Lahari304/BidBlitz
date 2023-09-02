package services;

import models.Event;
import models.Member;
import repositories.WinnerRepo;

public class WinnerService {

    WinnerRepo winnerRepo = WinnerRepo.getInstance();
    public void setWinner(Event event, Member winner){
        winnerRepo.getWinners().put(event, winner);
    }
    public void listWinners(){
        //event_id, winner_name, lowest_bid, date
        for(Event event: winnerRepo.getWinners().keySet()){
            System.out.println(event.getEventId()+" "
                    +getWinner(event).getName()+" "
                    +event.getWinningBid()+" "
                    +event.getDate());
        }
    }

    private Member getWinner(Event event){
        return winnerRepo.getWinners().get(event);
    }
}
