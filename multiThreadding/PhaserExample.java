import java.util.concurrent.*;
class PhaserExample {
    public static void main( String args[] ) {
        System.out.println("Phaser Example");
        // Phaser is Like an dynamic version of Cyclic Barrier
        Phaser phaser = new Phaser(3); // Expecting 3 Threads to await!
        ExecutorService executor = Executors.newFixedThreadPool(3); // Thread Pool with three threads!

        for (int i=0 ; i<21 ; i++) {
            executor.submit(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    int timeout = (int) (Math.random() * 1000);
                    Thread.sleep( timeout );
                    System.out.printf("Thread name :  %s has completed task for : %d ms\n" , threadName , timeout);
                } catch (Exception ex) {ex.printStackTrace();}
                phaser.arriveAndAwaitAdvance();
            });
        }

        executor.shutdown();
    }
}