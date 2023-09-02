package models;

public class Member {

    Integer memId;
    String name;
    Integer superCoins;

    public Member(Integer memId, String name, Integer superCoins) {
        this.memId = memId;
        this.name = name;
        this.superCoins = superCoins;
    }

    public String getName() {
        return name;
    }

    public Integer getSuperCoins() {
        return superCoins;
    }

}
