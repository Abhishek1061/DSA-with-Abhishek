package CollectionsFramework.Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap with parameters:
        // initialCapacity = 11, loadFactor = 0.3f, accessOrder = true
        // accessOrder = true means iteration order is based on access (get/put),
        // not insertion order. Internally, it maintains a doubly-linked list.
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.3f, true);

        // Adding key-value pairs
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 13);

        // Accessing elements using get() changes their order because accessOrder = true
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Guava");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");

        // Iterating over entries — order will reflect access sequence
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Creating a HashMap (unordered, no access/insertion order guarantee)
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Creating a LinkedHashMap from another Map (here, empty HashMap)
        // This constructor copies entries from the given map.
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap);

        // Adding entries to HashMap
        hashMap.put("Shubham", 91);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);

        // getOrDefault() returns value if key exists, else returns provided default
        Integer res = hashMap.getOrDefault("Vipul", 0); // Vipul not present → returns 0

        // putIfAbsent() adds key-value only if key is not already present
        hashMap.putIfAbsent("Shubham", 92); // Shubham already exists → no update

        // Printing HashMap (unordered output)
        System.out.println(hashMap);
    }
}
