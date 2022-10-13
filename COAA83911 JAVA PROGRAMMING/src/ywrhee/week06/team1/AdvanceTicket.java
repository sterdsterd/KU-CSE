package ywrhee.week06.team1;

public class AdvanceTicket extends Ticket{
    private int advanceDays;

    public AdvanceTicket(int number, double price, int advanceDays) {
        super(number, price);
        this.advanceDays = advanceDays;
    }

    @Override
    public double getPrice() {
        if (advanceDays >= 30)
            return price * 0.7;
        else if (advanceDays >= 20)
            return price * 0.8;
        else if (advanceDays >= 10)
            return price * 0.9;
        return price;
    }

    public int getAdvanceDays() {
        return advanceDays;
    }

    @Override
    public String toString() {
        String str = "티켓번호 : " + number + "\n";
        str += "티켓가격 : " + price + "\n";
        str += "예약일 : " + advanceDays + "일 전\n";
        str += "결제금액 : " + getPrice() + "\n";
        return str;
    }

}
