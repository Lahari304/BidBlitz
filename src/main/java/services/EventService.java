package services;

import exceptions.*;
import models.Bids;
import models.Event;
import models.Member;
import repositories.EventRepo;
import utils.AppUtil;

import java.util.List;
import java.util.Map;

public class EventService {

    EventRepo eventRepo = EventRepo.getInstance();
    WinnerService winnerService = new WinnerService();
    MemberService memberService = new MemberService();

    AppUtil appUtil = new AppUtil();

    public void addEvent(Integer id, String eventName, String prizeName, String date) {
        try{
            isDateAvailable(date);
        }
        catch (DateNotAvailableException e){
            System.out.println(e.getMessage()+date);
        }
        Event newEvent = new Event(id, eventName, prizeName, date);
        eventRepo.getEventMap().put(id, newEvent);
        System.out.println(eventName + " with prize " + prizeName + " added successfully");
    }

    public void registerMember(Integer memId, Integer eventId) {
        try {
            Event event = getEvent(eventId);
            Member member = memberService.getMember(memId);
            event.getRegisteredMembers().put(member, new Bids());
            System.out.println(member.getName() + " registered to the " + event.getName() + " event successfully ");
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage() + eventId);
        } catch (MemberNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void submitBid(Integer memId, Integer eventId, List<Integer> bids) {
        try {
            if(bids.size() > 5 || !appUtil.areUnique(bids))
                throw new TooManyBidsException();

            Event event = getEvent(eventId);
            Member member = memberService.getMember(memId);

            if (!isRegistered(event, member))
                throw new MemberNotRegisteredException();

            Bids bidObj = appUtil.updateBids(new Bids(bids));

            if(bidObj.getMaxBid() > member.getSuperCoins())
                throw new YoureBrokeException();

            event.getRegisteredMembers().remove(member);
            event.getRegisteredMembers().put(member, bidObj);
            System.out.println("BIDS submitted successfully");
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage() + eventId);
        } catch (MemberNotFoundException | MemberNotRegisteredException |
                 TooManyBidsException | YoureBrokeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void declareWinner(Integer eventId) {
        try {
            Event event = getEvent(eventId);
            Member winner = calculateWinner(event);
            System.out.println(winner.getName() + " wins the " + event.getPrizeName() + " with lowest bid "
                    + event.getWinningBid());
        } catch (EventNotFoundException | TiedResultException e) {
            System.out.println(e.getMessage() + eventId);
        }
    }
    private Event getEvent(Integer eventId) throws EventNotFoundException {
        Event event = eventRepo.getEventMap().get(eventId);
        if (event == null) throw new EventNotFoundException();
        return event;
    }

    private Member calculateWinner(Event event) throws TiedResultException {
        Integer lowestValue = Integer.MAX_VALUE;
        Bids lowestBids = null;
        Member winner = null;
        Map<Member,Bids> map = event.getRegisteredMembers();

        for (Member member : map.keySet()) {

            Bids bids = map.get(member);
            if(lowestValue > bids.getMinBid()){
                lowestValue = bids.getMinBid();
                lowestBids = bids;
                winner = member;
            }
            else if(lowestValue.equals(bids.getMinBid()) && lowestBids!=null && appUtil.compareDates(lowestBids, bids)){
                lowestBids = bids;
                winner = member;
            }
        }

        event.setWinningBid(lowestValue);
        winnerService.setWinner(event, winner);

        return winner;
    }

    private boolean isRegistered(Event event, Member member) {
        return event.getRegisteredMembers().containsKey(member);
    }

    private void isDateAvailable(String s) throws DateNotAvailableException {
        for(Event event: eventRepo.getEventMap().values()){
            if(event.getDate().equals(s)){
                throw new DateNotAvailableException();
            }
        }
    }
}
