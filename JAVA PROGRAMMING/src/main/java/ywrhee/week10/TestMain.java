package ywrhee.week10;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        long start, end;
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            list1.add(i);
        end = System.nanoTime();
        System.out.println("time: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            list2.add(i);
        end = System.nanoTime();
        System.out.println("time: " + (end - start));



    }
}
