package hu.java.eight;

public class ThreadSafeCounter {

    private Object lock;
    private int count;

    public ThreadSafeCounter() {
        this.lock = new Object();
        this.count = 0;
    }

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
