package ywrhee.week05;

import java.util.Scanner;

public class Salesman {
    private static final Scanner sc = new Scanner(System.in);

    private String name;
    private double sales;

    public Salesman() {
        readInput();
    }


    public void readInput() {
        System.out.print("이름: ");
        this.name = sc.next();

        System.out.print("실적: ");
        this.sales = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "이름: " + name + " / 실적: " + sales;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSales() {
        return sales;
    }

}
