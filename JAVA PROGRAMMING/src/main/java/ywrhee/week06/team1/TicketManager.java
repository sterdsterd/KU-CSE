package ywrhee.week06.team1;

public class TicketManager {
    private Ticket[] tickets;
    private final int NUMBER;
    private int count;
    private String name;

    public void showGeneralRicket(boolean payByCredit) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket instanceof GeneralTicket) {
                GeneralTicket g = (GeneralTicket) ticket;
                if (g.getPayByCredit() == payByCredit) {
                    System.out.println(g);
                }
            }
        }
    }

    public void showAdvanceTicket(int day) {
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket instanceof AdvanceTicket) {
                AdvanceTicket a = (AdvanceTicket) ticket;
                if (a.getAdvanceDays() > day) {
                    System.out.println(a);
                }
            }
        }
    }

    public TicketManager(String name, int NUMBER) {
        super();
        this.name = name;
        this.NUMBER = NUMBER;
        tickets = new Ticket[this.NUMBER];

    }

    public void register(Ticket ticket) {
        if (this.count < this.NUMBER)
            tickets[count++] = ticket;
        else System.out.println("매진");

    }

    public double getTotal() {
        double total = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) total += ticket.getPrice();
            else break;
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "공연명: " + this.name + '\n';
        str += "좌석수: " + this.NUMBER + '\n';
        str += "판매된 티켓 수: " + count + '\n';
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                str += ticket.toString() + '\n';
                str += "----------" + '\n';
            }
        }
        str += "총 판매금액: " + getTotal() + '\n';

        return str;
    }
}
