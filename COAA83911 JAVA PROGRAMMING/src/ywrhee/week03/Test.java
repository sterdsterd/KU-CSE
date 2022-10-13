package ywrhee.week03;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        lab03();
    }

    public static void lab01() {
        int[] lotto = makeLotto();
        if (lotto != null) {
            for (int num: lotto) {
                System.out.print(num + " ");
            }
        }
    }

    private static int[] makeLotto() {
        int[] lotto = new int[6];
        Random r = new Random();
        for (int i = 0; i < lotto.length; i++) {
            int tmp = r.nextInt(45) + 1;
            while (isDuplicated(lotto, tmp, i)) {
                tmp = r.nextInt(45) + 1;
            }
            lotto[i] = tmp;
        }
        return lotto;
    }

    private static boolean isDuplicated(int[] arr, int n, int i) {
        for (int j = 0; j < i; j++) {
            if(arr[j] == n) return true;
        }
        return false;
    }

    public static void lab02() {
        int[] answer = {1, 2, 3, 3, 2, 1};
        int[] std1 = {1, 2, 3, 4, 1, 1};
        int[] std2 = {1, 2, 3, 4, 1, 1};
        int[] std = new int[std1.length + std2.length];
        System.arraycopy(std1, 0, std, 0, std1.length);
        System.arraycopy(std2, 0, std, std1.length, std2.length);
        printArray(std);

        int[] quizResult = getQuizResult(answer, std1.clone());

        printArray(answer);
        printArray(std1);
        printArray(quizResult);

        printArray(new int[] {1, 2, 3, 4});
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] getQuizResult(int[] answer, int[] std1) {
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == std1[i]) std1[i] = 1;
            else std1[i] = 0;
        }
        return std1;
    }

    public static void lab03() {
        String[] stdnames = {"홍길동", "김길동", "고길동"};
        int[][] score = {
                {10, 20, 30, 0},
                {50, 60, 20, 0},
                {10, 50, 70, 0}
        };

        for (int[] arr : score) {
            for (int i = 0; i < arr.length - 1; i++) {
                //for (int num : arr) {
                arr[arr.length - 1] += arr[i];
            }
        }

        printArrayWithSum(score);

    }

    private static void printArrayWithSum(int[][] score) {
        for (int[] arr : score) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                if (i == arr.length - 2) System.out.print(": ");
            }
            System.out.println();
        }
    }

    private static int[][] makeArray2D() {
        Scanner sc = new Scanner(System.in);
        System.out.print("층의 개수 : ");
        final int ROW = sc.nextInt();
        int[][] arr = new int[ROW][];
        for (int i = 0; i < arr.length; i++) {

        }
        return arr;
    }
}
