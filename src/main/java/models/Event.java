package models;

import java.util.HashMap;
import java.util.Map;

public class Event {

    Integer eventId;
    String name;
    String prizeName;
    String date;  // yy-mm-dd
    Map<Member, Bids> registeredMembers;

    private Integer winningBid;

    public Event(Integer eventId, String name, String prizeName, String date) {
        this.eventId = eventId;
        this.name = name;
        this.prizeName = prizeName;
        this.date = date;
    }

    public Map<Member, Bids> getRegisteredMembers() {
        if (this.registeredMembers == null)
            this.registeredMembers = new HashMap<>();
        return registeredMembers;
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public Integer getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Integer winningBid) {
        this.winningBid = winningBid;
    }

    public String getDate() {
        return date;
    }
}
