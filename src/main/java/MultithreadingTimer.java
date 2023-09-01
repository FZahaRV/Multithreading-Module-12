import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class MultithreadingTimer {
    private int n;
    private final AtomicBoolean stop = new AtomicBoolean(false);

    public void multithreadingTimer(int n) {
        this.n = n;
        Thread timerThread = new Thread(this::timer);
        Thread fiveSecTimerThread = new Thread(this::fiveSecTimer);
        timerThread.start();
        fiveSecTimerThread.start();
    }
    public void timer() {
            Stream<Integer> t = Stream.iterate(1, i -> i + 1)
                    .limit(n)
                    .peek(i -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            t.filter(i -> i != 5).forEach(System.out::println);
            stop.set(true);
    }
    public void fiveSecTimer() {
        while (!stop.get()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5 seconds have passed");
        }
    }
}
