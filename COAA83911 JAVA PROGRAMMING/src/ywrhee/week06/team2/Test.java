package ywrhee.week06.team2;

public class Test {
    public static void main(String[] args) {
        System.out.println("이율원, 문신혁, 유재혁, 정명훈");
        Home home = new Home(10);
        home.buyHA(new Boiler("건국보일러", 15));
        home.buyHA(new Refrigerator("냉장고", 15));
        home.buyHA(new Vacuum("청소기", 1));
        home.buyHA(new TV("티비", 10));

        //home.open();
        IoTInterface iot = home.connect();
        if (iot != null) {
            iot.turnOn();
            iot.control();
            iot.turnOff();
        }
    }
}
