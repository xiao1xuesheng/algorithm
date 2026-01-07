package algorithm.queue_stack;

import java.util.Stack;

public class Stack1Test {

    public Stack<Integer> stack = new Stack<>();

    public int size() {
        return stack.size();
    }

    public void push(int num) {
        stack.push(num);
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
