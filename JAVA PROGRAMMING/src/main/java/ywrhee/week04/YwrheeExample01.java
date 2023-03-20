package ywrhee.week04;

public class YwrheeExample01 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("bora", 0, 1000, 'D', new TV());
        v1.showStatus();
        v1.tv.powerOnOff();
        v1.tv.channelUP();

        Vehicle v2 = new Vehicle(v1);
        v2.showStatus();
        //v2.tv.powerOnOff();
        v2.tv.channelDown();

        v1.tv.show();
        v2.tv.show();
    }
}
