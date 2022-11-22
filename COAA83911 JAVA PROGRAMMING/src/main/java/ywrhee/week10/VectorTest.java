package ywrhee.week10;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("greenjoa1");
        vector.add("greenjoa2");
        vector.add("greenjoa3");
        vector.add("greenjoa4");
        vector.add("greenjoa1");
        vector.add("greenjoa2");
        vector.add("greenjoa3");
        vector.add("greenjoa4");
        vector.add("greenjoa1");
        vector.add("greenjoa2");
        vector.add("greenjoa3");
        vector.add("greenjoa4");
        vector.add("greenjoa1");
        vector.add("greenjoa2");
        vector.add("greenjoa3");
        vector.add("greenjoa4");
        vector.add("greenjoa1");
        vector.add("greenjoa2");
        vector.add("greenjoa3");
        vector.add("greenjoa4");

        while (vector.contains("greenjoa3")) {
            vector.remove("greenjoa3");
        }


    }
}
