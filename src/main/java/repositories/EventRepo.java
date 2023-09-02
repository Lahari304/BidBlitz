package repositories;

import models.Event;

import java.util.HashMap;
import java.util.Map;

public class EventRepo {

    static EventRepo INSTANCE = new EventRepo();

    Map<Integer, Event> eventMap;

    private EventRepo() {

    }

    public static EventRepo getInstance() {
        return INSTANCE;
    }

    public Map<Integer, Event> getEventMap() {
        if(eventMap == null){
            eventMap = new HashMap<>();
        }
        return eventMap;
    }
}
