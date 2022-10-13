package ywrhee.week04;

public class TV {
    public boolean power = false;
    public int channel = 10;
    public int volume = 10;

    final int MAX_VOLUME = 20;
    final int MIN_VOLUME = 0;

    public void powerOnOff() {
        power = !power;
    }

    public void channelUP() {
        if(power)
            channel++;
        show();
    }


    public void channelDown() {
        if(power)
            channel--;
        show();
    }

    public void volumeUp() {
        if(power)
            if(volume < MAX_VOLUME)
                volume++;
            else System.out.println("볼륨을 " + MAX_VOLUME + " 이상 키울 수 없습니다.");
        show();
    }

    public void volumeDown() {
        if (power)
            if(MIN_VOLUME < volume)
                volume--;
            else System.out.println("볼륨을 " + MIN_VOLUME + " 이상 낮출 수 없습니다.");
        show();
    }

    public void changeChannel(int ch) {
        channel = ch;
        show();
    }

    public void changeVolume(int vol) {
        if (MIN_VOLUME <= vol && vol <= MAX_VOLUME)
            volume = vol;
        else System.out.println("볼륨은 " + MIN_VOLUME + "~" + MAX_VOLUME + " 사이의 값으로 설정해야 합니다.");
        show();
    }

    public void show() {
        if(power) {
            System.out.println("채널 " + channel + "번을 시청중입니다.");
            System.out.println("현재 볼륨은 " + volume + "입니다.");
        } else System.out.println("전원이 꺼져있습니다.");
        System.out.println();
    }

}
