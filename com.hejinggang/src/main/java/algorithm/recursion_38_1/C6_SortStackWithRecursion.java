package algorithm.recursion_38_1;

import java.util.Stack;

public class C6_SortStackWithRecursion {

    public static void sortStackWithRecursion(Stack<Integer> stack) {
        int deep = deep(stack);
        while (deep > 0) {
            int max = max(stack, deep);
            int times = times(stack, deep, max);
            down(stack, deep, max, times);
            deep = deep - times;
        }
    }

    private static int deep(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int ans = stack.pop();
        int deep = deep(stack) + 1;
        stack.push(ans);
        return deep;
    }

    private static int max(Stack<Integer> stack, int deep) {
        if (deep == 0) {
            return Integer.MIN_VALUE;
        }
        int ans = stack.pop();
        int max = max(stack, deep - 1);
        max = Math.max(max, ans);
        stack.push(ans);
        return max;
    }

    private static int times(Stack<Integer> stack, int deep, int max) {
        if (deep == 0) {
            return 0;
        }
        int ans = stack.pop();
        int times = times(stack, deep - 1, max) + (max == ans ? 1 : 0);
        stack.push(ans);
        return times;
    }

    private static void down(Stack<Integer> stack, int deep, int max, int times) {
        if (deep == 0) {
            for (int i=0; i<times; i++) {
                stack.push(max);
            }
            return;
        }
        int ans = stack.pop();
        down(stack, deep - 1, max, times);
        if (max != ans) {
            stack.push(ans);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(6);
        stack.push(2);
        stack.push(1);
        sortStackWithRecursion(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
