package ywrhee.week10;

public class TestMain {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>(5);
        MyArray<Integer> arr2 = new MyArray<>(4);
        arr2.add(10);
        arr2.add(10);
        arr2.add(10);
        arr2.add(10);
        arr2.add(10);

        MyArray<String> arr3 = new MyArray<>(3);
        arr3.add("greenjoa");


        MyArray<Word> wordArr = new MyArray<>(5);
        wordArr.add(new Word("green", "조아"));

    }
}
