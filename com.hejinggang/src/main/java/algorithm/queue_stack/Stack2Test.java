package algorithm.queue_stack;

public class Stack2Test {

    public int[] arr;

    public int size;

    public Stack2Test(int n) {
        arr = new int[n];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int num) {
        arr[size++] = num;
    }

    public int pop() {
        return arr[--size];
    }

    public int peek() {
        return arr[size - 1];
    }
}
