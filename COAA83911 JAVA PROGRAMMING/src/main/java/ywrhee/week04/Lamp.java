package ywrhee.week04;

public class Lamp {
    private boolean isOn = false;
    private int illuminance = 1;

    public Lamp() {

    }

    public Lamp(boolean isOn, int illuminance) {
        this.isOn = isOn;
        this.illuminance = (1 <= illuminance && illuminance <= 3) ? illuminance : 1;
    }

    public Lamp(boolean isOn) {
        this(isOn, 1);
    }

    public Lamp(int illuminance) {
        this(false, illuminance);
    }

    public Lamp(Lamp lamp) {
        isOn = lamp.isOn;
        illuminance = lamp.illuminance;
    }

    public void turnOnOff() {
        isOn = !isOn;
        printStatus();
    }

    public void changeLight() {
        illuminance++;
        if (illuminance == 4)
            illuminance = 1;

        printStatus();
    }

    public void printStatus() {
        if (!isOn) System.out.println("램프가 꺼져있습니다.");
        else System.out.println("조도 : " + illuminance);
    }

    public boolean isOn() {
        return isOn;
    }

    public int getIlluminance() {
        return illuminance;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setIlluminance(int illuminance) {
        this.illuminance = (1 <= illuminance && illuminance <= 3) ? illuminance : 1;
    }
}
