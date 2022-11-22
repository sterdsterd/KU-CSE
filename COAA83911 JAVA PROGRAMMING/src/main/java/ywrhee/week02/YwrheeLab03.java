package ywrhee.week02;

import java.util.Random;
import java.util.Scanner;

public class YwrheeLab03 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("가위(0), 바위(1), 보(2) 중에 하나를 입력해주세요.");
        System.out.print("입력 : ");
        int userChoice = sc.nextInt();
        int randomChoice = r.nextInt(3);

        System.out.println("user : " + (userChoice == 0 ? "가위" : userChoice == 1 ? "바위" : "보"));
        System.out.println(" com : " + (randomChoice == 0 ? "가위" : randomChoice == 1 ? "바위" : "보"));

        if (userChoice == randomChoice)  System.out.println("무승부");
        else if (userChoice - randomChoice == 1 || userChoice - randomChoice == -2)  System.out.println("승리");
        else System.out.println("패배");
    }
}
