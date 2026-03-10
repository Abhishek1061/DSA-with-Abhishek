package CollectionsFramework.Vector;

import java.util.ArrayList;
import java.util.Vector;

public class VectorTheadSafetyExp {
    public static void main(String[] args) {

        /*
        Below is the example of how ArrayList is not thread safe and how using
        Vector is important to achieve thread safety.
         */
        ArrayList<Integer> list =  new ArrayList<>();
        Thread t1  =  new Thread(() -> {
            for(int i = 0;  i < 1000; i++){
                list.add(i);
            }
        });
        Thread t2  =  new Thread(() -> {
            for(int i = 0;  i < 1000; i++){
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Size of list: " + list.size()); // Naturally output should be 2000 but as Arraylist is not thread safe O/p will be different.

        /*
        ///////////////////////////////////////////////////////
         */

        Vector<Integer> listVector =  new Vector<>();
        Thread t3 =  new Thread(() -> {
            for(int i = 0;  i < 1000; i++){
                listVector.add(i);
            }
        });
        Thread t4 =  new Thread(() -> {
            for(int i = 0;  i < 1000; i++){
                listVector.add(i);
            }
        });

        t3.start();
        t4.start();

        try{
            t3.join();
            t4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Size of listVector: " + listVector.size());  // This shows how Vector is thread safe how each task get completely executed.
    }

}
