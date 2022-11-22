package ywrhee.week05;

import java.util.Scanner;

public class YwrheeLab01 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        System.out.println("**** 팀 생성 ****");
        System.out.print("팀원 수 : ");
        int number = sc.nextInt();
        SalesReport team1 = new SalesReport(number);

        team1.computeStats();

        System.out.println();
        System.out.println("**** 최고사원 정보 ****");
        System.out.println(team1.getBestClerk());

        System.out.println();
        System.out.println("**** 팀 정보 ****");
        System.out.println(team1);
    }
}
