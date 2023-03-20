package ywrhee.week03;

public class YwrheeLab02 {
    public static void main(String[] args) {
        String[] arrName = { "홍길동", "고길동", "김길동", "이길동" };
        int[][] arrScore = {
                {10, 20, 30, 0},
                {20, 30, 40, 0},
                {10, 25, 30, 0},
                {30, 30, 40, 0}
        };

        for (int[] score : arrScore) {
            for (int i = 0; i < score.length - 1; i++) {
                score[score.length - 1] += score[i];
            }
        }

        for (int i = 0; i < arrName.length; i++) {
            System.out.print(arrName[i] + " >> ");
            for (int j = 0; j < arrScore[i].length; j++) {
                if (j == arrScore[i].length - 1) System.out.print(": ");
                System.out.print(arrScore[i][j] + " ");
            }

            int rank = 1;
            for (int j = 0; j < arrScore.length; j++) {
                if (arrScore[j][arrScore[j].length - 1] > arrScore[i][arrScore[i].length - 1]) rank++;
            }
            System.out.print(": " + rank);
            System.out.println();
        }
    }
}
