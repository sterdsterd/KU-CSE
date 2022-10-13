package ywrhee.midtest.ex;

public class YwrheeMember {
    private String name;
    private int participateNum;
    private int donationAmount;

    public YwrheeMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getParticipateNum() {
        return participateNum;
    }

    public int getDonationAmount() {
        return donationAmount;
    }

    public void addDonationAmount(int donationAmount) {
        this.donationAmount += donationAmount;
    }

    public void addParticipateNum() {
        participateNum++;
    }

    @Override
    public String toString() {
        String str = "회원 이름 : " + name + "\n";
        str += "자원봉사 참여 횟수 : " + participateNum + "회\n";
        str += "기부 총액 : " + donationAmount + "원\n";

        return str;
    }

}
