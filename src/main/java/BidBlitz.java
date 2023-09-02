import services.EventService;
import services.MemberService;
import services.WinnerService;
import utils.AppUtil;

import java.util.List;

public class BidBlitz {

    public static void main(String[] args) {

        AppUtil appUtil = new AppUtil();

        EventService eventService = new EventService();
        MemberService memberService = new MemberService();
        WinnerService winnerService = new WinnerService();
        String[] s = appUtil.getInputCases();
        int K = 0;

        boolean state = true;
        while (state) {
//            String[] input = appUtil.getScanner().nextLine().split(" ");
            String[] input = s[K].split(" ");
            System.out.println("\n" + s[K]);
            String command = input[0];
            switch (command) {
                case "ADD_MEMBER":
                    //id, name, coins
                    memberService.addMember(Integer.parseInt(input[1]), input[2], Integer.parseInt(input[3]));
                    break;
                case "ADD_EVENT":
                    // ADD_EVENT <id> <event_name> <prize_name> <date>
                    eventService.addEvent(Integer.parseInt(input[1]), input[2], input[3], input[4]);
                    break;
                case "REGISTER_MEMBER":
                    // memid, evId
                    eventService.registerMember(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "SUBMIT_BID":
                    List<Integer> bids = appUtil.getSubArrayAsList(input);
                    eventService.submitBid(Integer.parseInt(input[1]), Integer.parseInt(input[2]), bids);
                    break;
                case "DECLARE_WINNER":
                    eventService.declareWinner(Integer.parseInt(input[1]));
                    break;
                case "LIST_WINNERS":
                    winnerService.listWinners();
                    break;
                default:
                    state = false;
            }
            K++;
        }

    }
}


