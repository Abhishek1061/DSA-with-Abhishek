package CollectionsFramework.Vector;

import java.util.LinkedList;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector =  new Vector<>(5, 3);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        vector.add(1);
        System.out.println(vector.capacity()); // by default vector size doubles when the max capacity is hit.
        vector.add(1);
        System.out.println(vector.capacity());
        vector.add(1);
        vector.add(1);
        System.out.println(vector.capacity());
        vector.add(1);
        System.out.println(vector.capacity()); //capacity will increase by 3

        LinkedList<Integer> linkedList =   new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Vector<Integer> newVector =  new Vector<>(linkedList);
        System.out.println(newVector);
     }
}
