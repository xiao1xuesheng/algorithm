package algorithm.queue_stack;

import java.util.Stack;

public class StackToQueue {

    public Stack<Integer> in = new Stack<>();
    public Stack<Integer> out = new Stack<>();

    public void inToOut() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public void push(int num) {
        in.push(num);
        inToOut();
    }

    public int pop() {
        inToOut();
        return out.pop();
    }

    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}
