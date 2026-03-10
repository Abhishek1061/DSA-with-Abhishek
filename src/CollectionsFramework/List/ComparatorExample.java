package CollectionsFramework.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1 ;  // descending order // checks till the value is positive return
//        return o1 - o2; //ascending order
    }
}

public class ComparatorExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

//        list.sort(new IntegerComparator());
//        Using Lambda expression
        list.sort((a,b) -> b - a);
        System.out.println(list);

        List<String> words = Arrays.asList("banana", "apple", "date", "orange");
//        words.sort(new StringLengthComparator());

        // Alternate way of writing comparator using lambda expression
        words.sort((a, b) -> b.length() - a.length());
        System.out.println(words);
    }
}



