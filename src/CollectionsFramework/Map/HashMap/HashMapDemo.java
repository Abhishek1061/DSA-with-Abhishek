package CollectionsFramework.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map =  new HashMap<>();

        map.put(12, "Abhishek");
        map.put(14, "Himanshu");
        map.put(1, "Suraj");
        map.put(2, "Dipak");

        System.out.println(map);
        System.out.println(map.get(2));

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Abhishek"));
        System.out.println(map.remove(3));

        /*
        For running the loop in HashMap below are the ways.
         */

        Set<Integer> keys =  map.keySet();
        for(int i : keys){
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer,String>> entries =  map.entrySet();
        for(Map.Entry<Integer,String> entry : entries){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        for(Map.Entry<Integer,String> entry : entries){
            System.out.println(entry.getValue().toUpperCase());
        }
    }
}
