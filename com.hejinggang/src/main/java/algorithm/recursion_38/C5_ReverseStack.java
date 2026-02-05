package algorithm.recursion_38;

import java.util.Stack;

// 用递归函数逆序栈
public class C5_ReverseStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int ans = bottom(stack);
        reverse(stack);
        stack.push(ans);
    }

    public static int bottom(Stack<Integer> stack) {
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
        stack.push(4);
        stack.push(5);
        reverse(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
