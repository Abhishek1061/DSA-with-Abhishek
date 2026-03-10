package CollectionsFramework.List;

import java.lang.reflect.Field;
import java.util.*;

public class ArrayListExp {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        ArrayList<Integer> list = new ArrayList<>(11);
        list.add(1);
        list.add(5);
        list.add(88);
        System.out.println(list.get(2));
        System.out.println(list.size());

        // normal loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //Enhanced for loop
        for (int x : list) {
            System.out.println(x);
        }

        System.out.println(list.contains(5)); //true
        System.out.println(list.contains(50)); //false

        // remove
        list.remove(2);
        for (int x : list) {
            System.out.println(x);
        }

        // add in any index
        list.add(2, 50);
        System.out.println(list);

        list.set(2, 50); // this will replace the value of index 2
        System.out.println(list);

        // Internal working of ArrayList:
        /*
        Internally, the ArrayList is implemented as an array of Object references.
        Initial capacity is 10
        Unlike a regular array, which has a fixed size, an ArrayList can grow and shrink
        as elements are added or removed. This dynamic resizing is achieved by creating
        new array when the current array is full and copying the elements to the new array.
         */


        // Checking the capacity of an array using reflection
//        Field field  = ArrayList.class.getDeclaredField("elementData");
//        field.setAccessible(true);
//        Object[] elementData = (Object[]) field.get(list);
//        System.out.println("ArrayList capacity:" + elementData.length);
//
//        list.add(1);
//        elementData = (Object[]) field.get(list);
//        System.out.println("ArrayList capacity:" + elementData.length);


        List<String> list1 =  new ArrayList<>();
        System.out.println(list1.getClass().getName());

        // Arrays.asList();
        List<String> list2 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());
        // list2.add("Wednesday");  // we cannot add or remove element in asList().
        list2.set(1, "Wednesday"); // we can only replace the elements

        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list3=  Arrays.asList(array);
        System.out.println(list3);
        System.out.println(list3.getClass().getName());

        // List.of();
        List<Integer> list4 = List.of(1,2,3,4); //In .of() is immutable we cannot even replace elements in it.

        // Adding one list into another
        List<Integer> list5 =  new ArrayList<>();
        list5.add(1);
        list5.add(2);
        list5.add(3);
        list5.add(4);

        List<Integer> list6 = List.of(5,6,7,8,9);

        //.addAll method
        list5.addAll(list6);
        System.out.println(list5); //output: 1,2,3,4,5,6,7,8,9

        //Integer.valueOf();
        List<String> list7 =  new ArrayList<>();
        list7.add("apple");
        list7.add("banana");
        list7.add("mango");
        list7.add("papaya");

//        list7.remove(1); // this will remove banana as this will consider the index.
        list7.remove(Integer.valueOf(1)); // will remove the value of first occurrence mean apple
        System.out.println(list7);


        // we can convert list to array

        Object[] array1 =  list7.toArray();
        list7.toArray(new String[0]);  //  this will create new array Zero is just the convention not size of array.

        //Sort
        List<Integer> list8=  new ArrayList<>();
        list8.add(4);
        list8.add(1);
        list8.add(3);
        list8.add(2);

        Collections.sort(list8);
        System.out.println(list8);


    }
}
