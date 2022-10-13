package ywrhee.week04;

public class YwrheeLab01 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        TV tv = new TV();
        tv.powerOnOff();
        tv.channelUP();
        for (int i = 0; i < 11; i++) {
            tv.volumeUp();
        }
        tv.volumeDown();
        tv.channelDown();
    }
}

