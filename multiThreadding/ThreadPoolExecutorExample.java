import java.util.concurrent.*;
import java.time.Instant;
import java.util.*;
class ThreadPoolExecutorExample {

    public static void main (String[] args) {
        System.out.println("Thread Pool Example!");
        RunnableExecutorExample.run();
        CallableExecutorExample.call();
        System.out.println("Completed execution of all the threads!");
    }


    static class RunnableExecutorExample {
        public static void run() {
            // This is an expensive Java depends on 1000 Os threads!
            if (false)
                for (int i=0 ; i<999 ; i++) {
                    new Thread(new NotitifcationInvoker()).start();
                }

            // Number of cores available in my machine!
            int coreCount = Runtime.getRuntime().availableProcessors();
            System.out.println("Total number of cores : "+ coreCount);
            ExecutorService service = Executors.newFixedThreadPool(100);
            for (int i=0 ; i<10 ; i++) {
                service.execute(new NotitifcationInvoker() );
            }
            service.shutdown();
        }
    }

    static class NotitifcationInvoker implements Runnable {
        @Override
        public void run( ) {
            try {
                int timer = (int) (Math.random() * 10000);
                System.out.println("Email Notificaition sent from Tread : " + Thread.currentThread().getName()  +" Timer set : "+ timer );
                Thread.sleep( timer );
            } catch (InterruptedException ex) {
                System.err.println("Exception occured : " + ex.getMessage() );
            }
        }
    }

    static class CallableExecutorExample {
        public static void call() {
            List<Future<String>> result = new ArrayList<>();
            ExecutorService ioService = Executors.newCachedThreadPool();
            for (int i=0 ; i<10 ; i++) {
                result.add(ioService.submit( new GetDataFromApi() ));
            }
            try {
                String response;
                for ( Future<String> future : result ) {
                    response = future.get();
                    System.out.println("Response from the future : "+response);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ioService.shutdown();
        }
    }

    static class GetDataFromApi implements Callable<String> {
        @Override
        public String call() {
            try {
                System.out.println("Api Invoked awaiting response : thread name : " + Thread.currentThread().getName());
                Thread.sleep( (int) Math.random() * 100000 );
                System.out.println("Api Response received ! : thread name : " + Thread.currentThread().getName());
            } catch (InterruptedException ex ) {ex.printStackTrace();}
            return "Thread completed execution : " + Thread.currentThread().getName() + " at : " + Instant.now();
        }
    }

}