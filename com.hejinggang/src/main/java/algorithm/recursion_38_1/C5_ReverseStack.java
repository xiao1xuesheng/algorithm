package algorithm.recursion_38_1;

import java.util.Stack;

public class C5_ReverseStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int ans = bottom(stack);
        reverse(stack);
        stack.push(ans);
    }

    private static int bottom(Stack<Integer> stack) {
        int ans = stack.pop();
        if (stack.isEmpty()) {
            return ans;
        }
        int last = bottom(stack);
        stack.push(ans);
        return last;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
