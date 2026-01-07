package algorithm.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1Test {

    public Queue<Integer> queue = new LinkedList<>();

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void offer(int num) {
        queue.offer(num);
    }

    public int poll() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public int peek() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }
}
