import java.util.concurrent.*;
class CyclicBarrierExample {

    public static void main(String args[]) {
        System.out.println("Cyclic Barrier Example!");
        /* Cyclic Barrier is used to make Thread make wait for each other,
         - When results of each threads required to be comnined
        */
        int numberOfThreads = 3; // number of subtasks! ( threads count )
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads , () -> {
            System.out.println("All threads have reached their checkpoints!");
        }); // expects only 3 threadds at the time !

        // Lets start thre threads that each takes a random x amount of time to complete
        Workers workers = new Workers(barrier);
        try {
            for ( int i=0 ; i<3 ; i++ ) {
                new Thread( workers ).start();
            }
        } catch (Exception ex) {ex.printStackTrace();}


    }

    static class Workers implements Runnable {
        private CyclicBarrier barrier;

        Workers(CyclicBarrier barrier) {this.barrier=barrier;}

        @Override
        public void run() {
            try {
                int time = 2340;
                System.out.println("Started working on the Job Thread Name : " + Thread.currentThread().getName() + " for : " + time);
                Thread.sleep(time);
                System.out.printf("Completed working on the job for : " + time);
                barrier.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}