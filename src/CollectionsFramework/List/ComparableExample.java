package CollectionsFramework.List;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {
    public static void main(String[] args) {
        // ============================================
        // Example 1: Integer ArrayList
        // ============================================
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(50);
        numbers.add(20);

        // Collections.sort() internally calls compareTo() on each element
        // For Integer, compareTo() is implemented like this:
        // public int compareTo(Integer anotherInteger) {
        //     return this.value - anotherInteger.value;
        // }
        // So sorting is based on numeric difference
        Collections.sort(numbers);

        System.out.println("Sorted Integers: " + numbers);
        // Output: [10, 20, 30, 50]

        // ============================================
        // Example 2: String ArrayList
        // ============================================
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Cherry");

        // For String, compareTo() is implemented like this:
        // public int compareTo(String anotherString) {
        //     // Compares character by character using Unicode values
        //     // Returns negative if this < anotherString
        //     // Returns 0 if equal
        //     // Returns positive if this > anotherString
        // }
        // Sorting is lexicographic (dictionary order)
        Collections.sort(fruits);

        System.out.println("Sorted Strings: " + fruits);
        // Output: [Apple, Banana, Cherry, Mango]

        // ============================================
        // Internal Functioning Notes:
        // ============================================
        // 1. Comparable is an interface in java.lang with method:
        //    int compareTo(T o)
        //
        // 2. Classes like Integer and String already implement Comparable.
        //
        // 3. Collections.sort() works like this internally:
        //    - It uses a sorting algorithm (TimSort in modern Java).
        //    - During sorting, it repeatedly calls compareTo() to decide order.
        //
        // 4. compareTo() contract:
        //    - Returns negative if current object < other
        //    - Returns zero if current object == other
        //    - Returns positive if current object > other
        //
        // 5. For Integer:
        //    compareTo() subtracts values (this - other).
        //    Example: 10.compareTo(20) -> -10 (negative, so 10 < 20).
        //
        // 6. For String:
        //    compareTo() compares Unicode values of characters.
        //    Example: "Apple".compareTo("Banana") -> negative
        //    because 'A' (65) < 'B' (66).
        //
        // 7. Sorting in ArrayList:
        //    - Collections.sort() rearranges elements based on compareTo().
        //    - Final order depends entirely on compareTo() logic.
    }
}