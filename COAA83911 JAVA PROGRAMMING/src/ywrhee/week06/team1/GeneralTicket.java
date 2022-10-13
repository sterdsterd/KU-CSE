package ywrhee.week06.team1;

public class GeneralTicket extends Ticket {

    private boolean payByCredit;

    public GeneralTicket(int number, double price, boolean payByCredit) {
        super(number, price);
        this.payByCredit = payByCredit;
    }

    @Override
    public double getPrice() {
        return payByCredit ? price * 1.1 : price;
    }

    @Override
    public String toString() {
        return "티켓번호: " + number + "\n티켓가격: " + price + "\n카드결제 : " + payByCredit + "\n결제금액 : " + getPrice() + "\n";
    }

    public boolean getPayByCredit() {
        return payByCredit;
    }
}
