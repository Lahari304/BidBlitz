package services;

import exceptions.MemberNotFoundException;
import models.Member;
import repositories.MemberRepo;

public class MemberService {

//    private static MemberService INSTANCE = new MemberService();
//    private MemberService(){
//
//    }
//    public static MemberService getInstance() {
//        return INSTANCE;
//    }

    MemberRepo memberRepo = MemberRepo.getInstance();

    public void addMember(Integer id, String name, Integer superCoins){
        Member newMember = new Member(id,name,superCoins);
        memberRepo.getMemberMap().put(id, newMember);
        System.out.println(name+" added successfully");
    }

    Member getMember(Integer memId) throws MemberNotFoundException{
        Member member = memberRepo.getMemberMap().get(memId);
        if(member==null){
            throw new MemberNotFoundException();
        }
        return member;
    }

}
