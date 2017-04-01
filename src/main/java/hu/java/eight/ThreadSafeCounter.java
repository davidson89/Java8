package hu.java.eight;

public final class ThreadSafeCounter {

    private final Object lock;
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
