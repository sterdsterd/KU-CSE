package ywrhee.midtest.ex;

import java.util.Scanner;

public abstract class YwrheeVolunteer {
    protected String volunteerName;
    protected int admitNum;
    protected int participantNum;
    protected YwrheeMember[] participants = new YwrheeMember[5];
    protected int count = 0;

    protected static Scanner sc = new Scanner(System.in);

    public YwrheeVolunteer(String volunteerName, int admitNum) {
        this.volunteerName = volunteerName;
        this.admitNum = admitNum;
    }

    public abstract void join(YwrheeMember member);

    @Override
    public String toString() {
        String str = "자원봉사명 : " + volunteerName + "\n";
        str += "참여가능 인원 : " + admitNum + "명\n";
        str += "현재 참여인원 : " + participantNum + "명\n";

        return str;
    }

}
