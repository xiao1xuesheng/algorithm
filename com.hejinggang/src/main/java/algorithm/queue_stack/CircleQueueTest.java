package algorithm.queue_stack;

public class CircleQueueTest {

    public int []queue;

    int l, r, size, limit;

    public CircleQueueTest(int limit) {
        queue = new int[limit];
        l = r = size = 0;
        this.limit = limit;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }

    public void enQueue(int num) {
        if (isFull()) {
            return;
        }
        queue[r] = num;
        size++;
        r = (r + 1) % limit;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        l = (l + 1) % limit;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[l];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int last = (r + limit - 1) % limit;
        return queue[last];
    }
}
