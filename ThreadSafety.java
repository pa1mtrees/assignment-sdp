import java.util.ArrayList;
import java.util.List;

public class ThreadSafety {
        public static void main(String[] args) {
        int numThreads = 5;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                Singleton singleton = Singleton.getInstance();
                System.out.println("Thread " + Thread.currentThread().getId() + " Singleton instance: " + singleton.hashCode());
            });
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
