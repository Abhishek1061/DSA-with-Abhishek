// File: src/CollectionsFramework/Stack/StackDemo.java
package CollectionsFramework.Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push(E item): Adds an item to the top of the stack.
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After push: " + stack);

        // peek(): Returns the top element without removing it.
        System.out.println("Peek (top element): " + stack.peek());

        // pop(): Removes and returns the top element.
        int popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("After pop: " + stack);

        // empty(): Checks if the stack is empty.
        System.out.println("Is stack empty? " + stack.empty());

        // search(Object o): Returns 1-based position from top, or -1 if not found.
        stack.push(40);
        stack.push(50);
        System.out.println("Stack before search: " + stack);
        int pos = stack.search(20);
        System.out.println("Position of 20 from top: " + pos);
        int notFound = stack.search(100);
        System.out.println("Position of 100 from top: " + notFound);

        // Remove all elements
        while (!stack.empty()) {
            System.out.println("Removing: " + stack.pop());
        }
        System.out.println("Stack after removing all elements: " + stack);
    }
}