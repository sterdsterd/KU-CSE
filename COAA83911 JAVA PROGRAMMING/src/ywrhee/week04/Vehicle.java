package ywrhee.week04;

public class Vehicle {
    public String color;
    public int speed;
    public int mileage;
    public char gearStatus; // P, N, D
    public TV tv;

    public Vehicle() {
        this("black", 0, 0, 'P');
    }

    public Vehicle(String color, int mileage) {
        this(color, 0, mileage, 'P');
    }

    public Vehicle(String color, int speed, int mileage, char gearStatus) {
        this.color = color;
        this.speed = speed;
        this.mileage =  mileage;
        this.gearStatus = gearStatus;
    }

    public Vehicle(String color, int speed, int mileage, char gearStatus, TV tv) {
        this(color, speed, mileage, gearStatus);
        //this.tv = new TV(tv);
    }

    public Vehicle(Vehicle v) {
        color = v.color;
        speed = v.speed;
        mileage = v.mileage;
        gearStatus = v.gearStatus;
        //tv = new TV(v.tv);
    }

    public void accelerate(int s) {
        if (gearStatus == 'D') {
            speed += s;
            mileage += s;
        }
    }

    public void breaker(int b) {
        if (gearStatus == 'D') {
            speed -= b;
        }
    }

    public void showStatus() {
        System.out.println("색상 : " + color);
        System.out.println("속도 : " + speed);
        System.out.println("주행거리 : " + mileage);

        System.out.print("기어상태 : ");
        switch (gearStatus) {
            case 'P':
                System.out.println("주차");
                break;
            case 'D':
                System.out.println("주행 중");
                break;
            case 'N':
                System.out.println("중립");
                break;
        }
    }

    public void changeGear(char g) {
        gearStatus = g;
    }

}
