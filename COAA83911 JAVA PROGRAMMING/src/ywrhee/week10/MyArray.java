package ywrhee.week10;

public class MyArray<E> {
    private int capacity;
    private int count = 0;
    private E[] arr;

    @SuppressWarnings("unchecked")
    public MyArray(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[this.capacity];
    }

    public void add(E data) {
        if (this.count < this.capacity)
            this.arr[count++] = data;
        else
            System.out.println("공간 부족");
    }

    public E getElement(int index) {
        if (index >= 0 && index <= count)
            return arr[index];
        else
            return null;
    }




}
