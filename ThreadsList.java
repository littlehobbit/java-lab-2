import java.util.LinkedList;

public class ThreadsList {
    private LinkedList<Thread> list;

    public ThreadsList() {
        this.list = new LinkedList<>();
    }

    public void addThread(Thread thread) {
        list.add(thread);
    }

    public void startAll() {
        for (Thread thread : list) {
            thread.start();
        }
    }

    public void joinAll() throws InterruptedException {
        for (Thread thread : list) {
            thread.join();
        }
    }
}
