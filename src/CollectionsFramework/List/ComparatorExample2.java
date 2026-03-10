package CollectionsFramework.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Charlet", 3.5));
        students.add(new Student("Abhishek", 3.9));

        //  this below logic is comparator logic where I am sorting it on basis of gpa score.
//        students.sort((o1, o2) -> {
//            if (o2.getGpa() - o1.getGpa() > 0) {
//                return 1;
//            } else if (o2.getGpa() - o1.getGpa() < 0) {
//                return -1;
//            } else {
////                return 0;
//                // if you need to filter it out on basis of name you may use below line of code
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        // Another way of writing the code using Java8 feature.
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student :: getName);  // :: means method reference.

        students.sort(comparator);

        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
    }
}

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}