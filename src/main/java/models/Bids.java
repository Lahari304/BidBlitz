package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bids {
    private List<Integer> bidList;
    private Integer maxBid;
    private Integer minBid;
    private final LocalDateTime timestamp;

    public Bids() {
        this.bidList = new ArrayList<>(5);
        this.timestamp = LocalDateTime.now();
    }

    public Bids(List<Integer> bids) {
        this.bidList = bids;
        this.timestamp = LocalDateTime.now();
    }

    public List<Integer> getBidList() {
        return bidList;
    }

    public Integer getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(Integer maxBid) {
        this.maxBid = maxBid;
    }

    public Integer getMinBid() {
        return minBid;
    }

    public void setMinBid(Integer minBid) {
        this.minBid = minBid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
