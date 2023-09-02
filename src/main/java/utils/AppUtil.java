package utils;

import exceptions.TiedResultException;
import models.Bids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public AppUtil() {

    }

    public static Scanner getScanner() {
        return scanner;
    }

    public boolean compareDates(Bids b1, Bids b2) throws TiedResultException {

        int compared = b1.getTimestamp().compareTo(b2.getTimestamp());

        if (compared > 0) return false;
        else if (compared == 0) {
            throw new TiedResultException();
        }

        return true;
    }

    public String[] getInputCases() {
        String[] s = new String[10];
        s[0] = "ADD_MEMBER 1 Akshay 10000";
        s[1] = "ADD_MEMBER 2 Chris 5000";
        s[2] = "ADD_EVENT 1 BBD IPHONE-14 2023-06-06";
        s[3] = "REGISTER_MEMBER 1 1";
        s[4] = "SUBMIT_BID 1 1 100 200 400 500 600";
        s[5] = "SUBMIT_BID 2 1 100 200 400 500";
        s[6] = "SUBMIT_BID 10 1 100 200 300 400 500";
        s[7] = "DECLARE_WINNER 1";
        s[8] = "LIST_WINNERS asc";
        s[9] = "exit ";

        return s;
    }

    public List<Integer> getSubArrayAsList(String[] arr) {
        String[] subArray = Arrays.copyOfRange(arr, 3, arr.length);
        return toIntegerList(subArray);
    }

    private List<Integer> toIntegerList(String[] arr) {
        List<Integer> list = new ArrayList<>();
        for (String s : arr) {
            list.add(Integer.parseInt(s));
        }

        return list;
    }

    public Bids updateBids(Bids bids) {
        int maxBid = Integer.MIN_VALUE, minBid = Integer.MAX_VALUE;

        for (Integer bid : bids.getBidList()) {
            if (bid < minBid) {
                minBid = bid;
            } else if (bid > maxBid) {
                maxBid = bid;
            }
        }

        bids.setMaxBid(maxBid);
        bids.setMinBid(minBid);

        return bids;
    }

    public boolean areUnique(List<Integer> bids) {
        for (int i = 0; i < bids.size(); i++) {
            Integer curr = bids.get(i);
            for (int j = i + 1; j < bids.size(); j++) {
                if (bids.get(j).equals(curr)) return false;
            }
        }

        return true;
    }
}
