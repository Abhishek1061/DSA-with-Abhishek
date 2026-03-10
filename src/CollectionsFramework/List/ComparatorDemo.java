package CollectionsFramework.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Students {
    String name;
    int marks;

    Students(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Students> students = new ArrayList<>();
        students.add(new Students("Alice", 85));
        students.add(new Students("Bob", 72));
        students.add(new Students("Charlie", 90));
        students.add(new Students("David", 72));

        // ============================================
        // Example 1: Sort by marks (ascending)
        // ============================================
        Comparator<Students> marksComparator = new Comparator<Students>() {
            @Override
            public int compare(Students s1, Students s2) {
                // Compare by marks
                return Integer.compare(s1.marks, s2.marks);
            }
        };

        Collections.sort(students, marksComparator);
        System.out.println("Sorted by marks: " + students);
        // Output: [Bob (72), David (72), Alice (85), Charlie (90)]

        // ============================================
        // Example 2: Sort by name (alphabetical)
        // ============================================
        Comparator<Students> nameComparator = new Comparator<Students>() {
            @Override
            public int compare(Students s1, Students s2) {
                // Compare by name lexicographically
                return s1.name.compareTo(s2.name);
            }
        };

        Collections.sort(students, nameComparator);
        System.out.println("Sorted by name: " + students);
        // Output: [Alice (85), Bob (72), Charlie (90), David (72)]

        // ============================================
        // Notes:
        // ============================================
        // 1. Comparator is in java.util package.
        // 2. It defines: int compare(Object o1, Object o2).
        // 3. Unlike Comparable, sorting logic is external.
        // 4. Collections.sort(list, comparator) uses the comparator
        //    to decide ordering instead of natural ordering.
        // 5. Advantage: You can define multiple comparators for
        //    different sorting strategies (marks, name, etc).
    }
}