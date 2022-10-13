package ywrhee.week06.team1;

public abstract class Ticket {
    protected int number;
    protected double price;

    public Ticket(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return "티켓번호: " + number + "\n티켓가격:" + price;
    }
}
