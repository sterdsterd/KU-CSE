package ywrhee.week02;

import java.util.Scanner;

public class YwrheeLab01 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        Scanner sc = new Scanner(System.in);
        System.out.print("학번 : ");
        int studentId = sc.nextInt();

        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("나이 : ");
        int age = sc.nextInt();

        System.out.print("주소 : ");
        sc.nextLine();
        String address = sc.nextLine();

        System.out.println("학번 : " + studentId);
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + address);

    }
}
