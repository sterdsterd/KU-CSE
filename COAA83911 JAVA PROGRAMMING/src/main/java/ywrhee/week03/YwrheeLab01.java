package ywrhee.week03;

import java.util.Random;

public class YwrheeLab01 {
    public static void main(String[] args) {
        System.out.println("202211342 이율원");
        System.out.print("로또 번호 : ");
        boolean[] lotto = makeLotto();
        for (int i = 0; i < 46; i++) {
            if (lotto[i]) System.out.print(i + " ");
        }
    }

    private static boolean[] makeLotto() {
        boolean[] lotto = new boolean[46];
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int tmp = r.nextInt(45) + 1;
            if (lotto[tmp]) {
                i--;
                continue;
            }
            lotto[tmp] = true;
        }
        return lotto;
    }

}
