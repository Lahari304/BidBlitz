package repositories;

import models.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepo {

    private static MemberRepo INSTANCE = new MemberRepo();

    Map<Integer, Member> memberMap;
    private MemberRepo(){

    }

    public static MemberRepo getInstance(){
        return INSTANCE;
    }

    public Map<Integer, Member> getMemberMap() {
        if(memberMap == null){
            memberMap = new HashMap<>();
        }
        return memberMap;
    }
}
