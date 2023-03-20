package ywrhee.assignment01;

import java.util.Scanner;

public class YwrheeAssignment01 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        for (;;) {
            System.out.println("1) 쿠폰으로 초콜릿 구매하기  2) 문자 산수 퍼즐  3) 구구단 출력하기  4) 종료");
            System.out.print("메뉴를 선택하세요 : ");
            int choice = sc.nextInt();
            if (choice == 1) menu1();
            else if (choice == 2) menu2();
            else if (choice == 3) menu3();
            else if (choice == 4) break;
        }
    }

    public static void menu1() {
        System.out.println("문제1. 쿠폰으로 초콜릿 구매하기");
        System.out.print("돈을 넣어 주세요 : ");
        int money = sc.nextInt();

        int chocolate = money, coupon = money;
        for (; coupon >= 7; chocolate += coupon / 7, coupon = coupon % 7 + coupon / 7);

        System.out.println("--------------------");
        System.out.println("초콜릿 " + chocolate + "개, 쿠폰 " + coupon + "개");
        System.out.println("--------------------");
    }

    public static void menu2() {
        for (int D = 0; D < 10; D++) {
            for (int G = 1; G < 10; G++) { // Since GOOD is 4 digit integer, G must be larger than 0
                if (G == D) continue; // All letters stand for different digits

                for (int O = 0; O < 10; O++) {
                    if (O == D || O == G) continue;

                    for (int T = 0; T < 10; T++) {
                        if (T == D || T == G || T == O) continue;

                        if (4 * (T * 100 + O * 10 + O) == G * 1000 + O * 100 + O * 10 + D)
                            System.out.printf("D = %d, G = %d, O = %d, T = %d\n", D, G, O, T);
                    }
                }
            }
        }
    }

    public static void menu3() {
        System.out.println("====== 구구단 출력하기 ======");
        int col;
        boolean isOnce = true;
        do {
            if (!isOnce) System.out.println("출력 단 수 입력이 잘못되었습니다.");
            System.out.print("출력 단수 : ");
            col = sc.nextInt();
            isOnce = false;
        } while (1 > col || col > 8);

        for (int i = 0; i < 8.0 / col; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 2 + i * col; k <= 9  && k < 2 + (i + 1) * col; k++) {
                    String space = (j * k / 10) < 1 ? " " : "";
                    System.out.print(k + " * " + j + " = " + space + j * k + "     ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
