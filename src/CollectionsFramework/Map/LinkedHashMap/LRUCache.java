package CollectionsFramework.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

// Custom LRUCache class extending LinkedHashMap
// LRU = Least Recently Used cache
// It automatically removes the oldest accessed entry when capacity is exceeded.
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity; // maximum number of entries allowed

    // Constructor
    public LRUCache(int capacity) {
        // super(capacity, loadFactor, accessOrder)
        // capacity = initial capacity of map
        // loadFactor = 0.75f (default, controls resizing)
        // accessOrder = true → maintains order based on access (get/put), not insertion
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // Overriding removeEldestEntry
    // This method is called after every put()
    // If size exceeds capacity, eldest entry (least recently used) is removed
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        // Create LRUCache with capacity = 3
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);

        // Adding entries
        studentMap.put("Bob", 99);     // cache = {Bob=99}
        studentMap.put("Alice", 89);   // cache = {Bob=99, Alice=89}
        studentMap.put("Ram", 91);     // cache = {Bob=99, Alice=89, Ram=91}

        // Updating Bob’s value (Bob becomes most recently used)
        studentMap.put("Bob", 100);    // cache = {Alice=89, Ram=91, Bob=100}

        // Adding Vipul → capacity exceeded (4 entries)
        // removeEldestEntry() removes least recently used (Alice)
        studentMap.put("Vipul", 89);   // cache = {Ram=91, Bob=100, Vipul=89}

        // Printing final cache
        System.out.println(studentMap);

    }
}
