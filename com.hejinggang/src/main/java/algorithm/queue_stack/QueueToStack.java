package algorithm.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int num) {
        int n = queue.size();
        queue.offer(num);
        for (int i=0; i<n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
