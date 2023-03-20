package ywrhee.week11;

import ywrhee.week10.Word;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
//        Stack<Word> stack = new Stack<>();
//        stack.add(new Word("red", "빨강"));
//        stack.add(new Word("green", "초록"));
//        stack.add(new Word("blue", "파랑"));
//
//        Iterator<Word> itStack = stack.iterator();
//
//        while (itStack.hasNext()) {
//            System.out.println(itStack.next());
//        }
//
//        while (!stack.isEmpty())
//            System.out.println(stack.pop());

//        Deque<Word> queue = new LinkedList<>();
//        queue.offer(new Word("red", "빨강"));
//        queue.offer(new Word("green", "초록"));
//        queue.offer(new Word("blue", "파랑"));
//        Iterator<Word> itQueue = queue.iterator();
//
//        while (itQueue.hasNext()) {
//            System.out.println(itQueue.next());
//        }
//
//        while (!queue.isEmpty())
//            System.out.println(queue.poll());
//
//
//        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        List<Integer> list = Arrays.asList(arr);
//        Collections.addAll(list, arr);
//        Collections.shuffle(list);
//
//        Collections.sort(list, Collections.reverseOrder());

        List<Student> list = new ArrayList<>();
        list.add(new Student("홍길동", "1234", 100));
        list.add(new Student("이길동", "12345", 1));
        list.add(new Student("최길동", "123456", 52));
        list.add(new Student("김길동", "1234567", 23));

        Collections.shuffle(list);

        for (Student student : list)
            System.out.println(student);

        System.out.println();
        System.out.println();
        Collections.sort(list);

        for (Student student : list)
            System.out.println(student);
        System.out.println();
        System.out.println();


        Collections.sort(list, (o1, o2) -> -(o1.score - o2.score));

        for (Student student : list)
            System.out.println(student);
        System.out.println();
        System.out.println();


        Collections.sort(list, (o1, o2) -> o1.sname.compareTo(o2.sname));

        for (Student student : list)
            System.out.println(student);
        System.out.println();
        System.out.println();


        StdComparator cmp = new StdComparator(StdComparator.STUDENT_COMPARE.SID);
        Collections.sort(list, cmp);
        for (Student student : list)
            System.out.println(student);
        System.out.println();
        System.out.println();



    }
}
