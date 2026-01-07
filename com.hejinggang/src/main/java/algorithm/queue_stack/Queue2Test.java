package algorithm.queue_stack;

public class Queue2Test {

    public int[]arr;
    public int l;
    public int r;
    int n;

    public Queue2Test(int n) {
        arr = new int[n];
        l = 0;
        r = 0;
        this.n = n;
    }

    public boolean isEmpty() {
        return r == l;
    }

    public void offer(int num) {
        if ((r + 1) % n == l) {
            return;
        }
        arr[r] = num;
        r = (r + 1) % n;
    }

    public int poll() {
        if (this.isEmpty()) {
            return -1;
        }
        int ret = arr[l];
        l = (l + 1) % n;
        return ret;
    }

    public int peek() {
        if (this.isEmpty()) {
            return -1;
        }
        return arr[l];
    }

    public int size() {
        return (r + n - l - 1) % n;
    }
}
