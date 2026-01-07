package algorithm.queue_stack;

import java.util.Stack;

public class GetMinStack {

    Stack<Integer> data;
    Stack<Integer> minStack;

    public GetMinStack() {
        data = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (data.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }
    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
