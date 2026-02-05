package algorithm.recursion_38;

import java.util.Stack;

// 用递归函数排序栈
// 栈只提供push、pop、isEmpty三个方法
// 请完成无序栈的排序，要求排完序之后，从栈顶到栈底从小到大
// 只能使用栈提供的push、pop、isEmpty三个方法、以及递归函数
// 除此之外不能使用任何的容器，数组也不行
// 就是排序过程中只能用：
// 1) 栈提供的push、pop、isEmpty三个方法
// 2) 递归函数，并且返回值最多为单个整数
public class C6_SortStackWithRecursion {

    public static void sort(Stack<Integer> stack) {
        int deep = deep(stack);
        while (deep > 0) {
            int max = max(stack, deep);
            int times = times(stack, max, deep);
            down(stack, max, deep, times);
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
        int max = Math.max(ans, max(stack, deep - 1));
        stack.push(ans);
        return max;
    }

    private static int times(Stack<Integer> stack, int max, int deep) {
        if (deep == 0) {
            return 0;
        }
        int ans = stack.pop();
        int times = times(stack, max, deep - 1) + (max == ans ? 1 : 0);
        stack.push(ans);
        return times;
    }

    private static void down(Stack<Integer> stack, int max, int deep, int times) {
        if (deep == 0) {
            for (int i=0; i<times; i++) {
                stack.push(max);
            }
            return;
        }
        int ans = stack.pop();
        down(stack, max, deep - 1, times);
        if (max != ans) {
            stack.push(ans);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(1);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
