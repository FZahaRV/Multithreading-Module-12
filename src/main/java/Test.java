public class Test {
        public static void main(String[] args) throws InterruptedException {
            MultithreadingTimer multithreading = new MultithreadingTimer();
            multithreading.multithreadingTimer(10);
            FizzbuzzCounter counter = new FizzbuzzCounter();
            counter.fizzbuzzCounter(99);
        }
}

