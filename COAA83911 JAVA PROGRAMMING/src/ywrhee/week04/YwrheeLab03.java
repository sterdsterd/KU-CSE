package ywrhee.week04;

public class YwrheeLab03 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        System.out.println("== LAMP 1==");
        Lamp lamp1 = new Lamp();
        lamp1.printStatus();
        lamp1.turnOnOff();
        for (int i = 0; i < 6; i++) {
            lamp1.changeLight();
        }

        System.out.println("\n== LAMP 2==");
        Lamp lamp2 = new Lamp(true, 3);
        lamp2.printStatus();

        System.out.println("\n== LAMP 3==");
        Lamp lamp3 = new Lamp(lamp2);
        lamp3.printStatus();
        lamp3.changeLight();

        System.out.print("\nLAMP 2 : ");
        lamp2.printStatus();
        System.out.print("\nLAMP 3 : ");
        lamp3.printStatus();

        System.out.println("주소 같음 : " + (lamp2 == lamp3)); // To check lamp 3 is deep copied

        System.out.println("\n== LAMP 4==");
        Lamp lamp4 = new Lamp(5);
        lamp4.printStatus();
        lamp4.turnOnOff();
    }
}
