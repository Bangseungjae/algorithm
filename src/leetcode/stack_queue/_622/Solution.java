package leetcode.stack_queue._622;

class MyCircularQueue {
    int[] q;
    private int len = 0;
    private int rear = -1;
    private int front = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % q.length;
        q[rear] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % q.length;
        len--;
        return true;
    }

    public int Front() {
        if (len == 0) {
            return -1;
        }
        return q[front];
    }

    public int Rear() {
        if (len == 0) {
            return -1;
        }
        return q[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return q.length == len;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
