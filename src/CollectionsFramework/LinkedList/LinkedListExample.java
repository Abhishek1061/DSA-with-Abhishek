package CollectionsFramework.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList =  new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.get(2); // O(n)
        linkedList.addLast(4); // O(1)
        linkedList.addFirst(0); // O(1)
        linkedList.getFirst();
        linkedList.getLast();
        System.out.println(linkedList);
        linkedList.removeIf(x -> x% 2 == 0); //java 8 feature predicate, this will remove the even element.
        System.out.println(linkedList);

        LinkedList<String> animals  = new LinkedList<>(Arrays.asList("Cat", "dog", "Elephant"));
        LinkedList<String> animalsToRemove  = new LinkedList<>(Arrays.asList("dog", "Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
