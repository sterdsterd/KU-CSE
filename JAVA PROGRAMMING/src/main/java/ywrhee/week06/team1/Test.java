package ywrhee.week06.team1;

public class Test {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        TicketManager manager = new TicketManager("아이유 콘서트", 10);
        //manager.register(new Ticket(1, 1000));
        manager.register(new GeneralTicket(2, 5000.0, false));
        manager.register(new AdvanceTicket(3, 1000.0, 32));
        //manager.register(new Ticket(4, 1000));
        manager.register(new GeneralTicket(5, 5000.0, false));
        manager.register(new AdvanceTicket(6, 1000.0, 15));
        manager.register(new AdvanceTicket(7, 1000.0, 10));
        manager.register(new AdvanceTicket(8, 1000.0, 60));

        manager.showAdvanceTicket(30);

//        System.out.println(manager);
//        Ticket ticket1 = new Ticket(1, 1000);
//        System.out.println(ticket1);
//        ticket1.setPrice(2000);
//        System.out.println(ticket1);
//        System.out.println();
//
//        GeneralTicket g1 = new GeneralTicket(1, 5000.0, false);
//        GeneralTicket g2 = new GeneralTicket(2, 2000.0, true);
//        System.out.println(g1);
//        System.out.println(g2);
//        System.out.println();
//
//        AdvanceTicket t1 = new AdvanceTicket(1, 1000.0, 32);
//        AdvanceTicket t2 = new AdvanceTicket(2, 2000.0, 15);
//        System.out.println(t1);
//        System.out.println(t2);

    }
}
