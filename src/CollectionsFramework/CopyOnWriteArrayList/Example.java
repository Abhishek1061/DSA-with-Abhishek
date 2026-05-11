package CollectionsFramework.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
    public static void main(String args[]){
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // List<String> shoppingList  =  new ArrayList<>(); // This will throw ConcurrentModificationException, as ArrayList is not thread safe and does not allow concurrent modifications while iterating.
        List<String> shoppingList  =  new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Original shopping list: " + shoppingList);

        for(String items : shoppingList){
            System.out.println(items);
            if(items.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added butter while reading");
            }
        }

        System.out.println("Updated shopping list: " + shoppingList);

        // List<String> sharedList  = new ArrayList<>();   // This will throw ConcurrentModificationException, as ArrayList is not thread safe and does not allow concurrent modifications while iterating.
        List<String> sharedList  = new CopyOnWriteArrayList<>(); // No exception, as CopyOnWriteArrayList creates a new copy of the list for each modification, allowing safe concurrent reads and writes.
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readerThread =  new Thread(()-> {
            try{
                while(true){
                    for(String item: sharedList){
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100); // small delay too simulate work
                    }
                }
            }catch(Exception e){
                System.out.println("Exception in reader thread: " + e);
            }
        });

        Thread writerThread  =  new Thread(() -> {
            try{
                Thread.sleep(500); // delay to allow reader to start first
                sharedList.add("Item4");
                System.out.println("Added Item4 to the list");

                Thread.sleep(500); // delay to allow reader to read the new item
                sharedList.remove("Item1");
                System.out.println("Removed Item1 from the list");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        readerThread.start();
        writerThread.start();

    }
}
