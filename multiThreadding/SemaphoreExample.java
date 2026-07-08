import java.util.concurrent.*;
class SemaphoreExample {
    public static void main (String args[]) {
        System.out.println("Semaphore Example");
        // Controlling access to shared resource
        Semaphore semaphore = new Semaphore(2); // restricting access to only 5 resource only!
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 Threads!


        for (int i=0 ; i<10 ; i++) {
                // At a time out of 10 fixed Thread pool only two threads would be processing the request at a particular time!
                executor.submit( () -> {
                    try {
                        System.out.println("Requesting semaphore access : " + Thread.currentThread().getName());
                        semaphore.acquire();
                        System.out.println("==> currently Processing : " + Thread.currentThread().getName());
                        // simulate task!
                        int timeout = (int) (Math.random() * 1000);
                        Thread.sleep( timeout );
                        System.out.println("Thread "+ Thread.currentThread().getName() +" slept for : " + timeout);
                        semaphore.release();
                    } catch (Exception ex) {ex.printStackTrace();}
                });

        }

        executor.shutdown();

    }


}