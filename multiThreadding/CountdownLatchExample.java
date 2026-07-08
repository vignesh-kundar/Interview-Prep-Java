import java.util.concurrent.*;

class CountdownLatchExample {
    public static void main(String args[]) {
        System.out.println("This is an Example of count down Latch");
        CountDownLatch latch = new CountDownLatch(4); // sets latch count to 4!

        TyreWorkers task = new TyreWorkers( latch );
        for (int i=1 ; i<5 ; i++)
            new Thread( task ).start();
        try {
            latch.await(); // Awaits on Main Thread!
        } catch (InterruptedException ex) {ex.printStackTrace();}
    }

    static class TyreWorkers implements Runnable {
        private CountDownLatch latch;
        TyreWorkers(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Changine tyre...");
                Thread.sleep(1000);
                System.out.println("TyreChanged! latc count : " + latch.getCount() );
                latch.countDown(); // after completeion of every latch it countdowns by one
            }catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}