package ywrhee.week02;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.next();
            char ch = str.charAt(0);
            if ('A' <= ch && ch <= 'Z') {
                System.out.println(ch + " is a Capital Letter.");
            } else if ('a' <= ch && ch <= 'z') {
                System.out.println(ch + " is a Small Letter.");
            } else if ('0' <= ch && ch <= '9') {
                System.out.println(ch + " is a Number.");
            } else System.out.println(ch + " is a Special Character.");

        }
    }
}
