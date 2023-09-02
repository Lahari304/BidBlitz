package repositories;

import models.Event;
import models.Member;

import java.util.HashMap;
import java.util.Map;

public class WinnerRepo {

    private static WinnerRepo INSTANCE = new WinnerRepo();

    private static Map<Event, Member> winners;
    private WinnerRepo(){

    }

    public static WinnerRepo getInstance() {
        return INSTANCE;
    }

    public Map<Event, Member> getWinners() {
        if(winners == null){
            winners = new HashMap<>();
        }
        return winners;
    }
}
