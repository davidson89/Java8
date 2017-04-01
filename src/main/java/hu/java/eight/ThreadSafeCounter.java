package hu.java.eight;

final class ThreadSafeCounter {

    private final Object lock;
    private int count;

    ThreadSafeCounter() {
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
