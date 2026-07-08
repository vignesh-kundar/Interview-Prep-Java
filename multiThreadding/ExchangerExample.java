import java.util.concurrent.*;
class ExchangerExample {
    public static void main (String args[]) {
        System.out.println("Exchanger example!");
        // Exchanger is basically used to exchange data between two threads!

        Exchanger<String> exchanger = new Exchanger<String>();
        //producer
        Thread producer = new Thread( () -> {
            String producerMessage = "why are you gay ?";
            try {
                while (true) {
                    System.out.println("---------------------->");
                    System.out.println("Producer sent Message ->  "+ producerMessage);
                    producerMessage = exchanger.exchange(producerMessage);
                    System.out.println("Producer received Message -> "+ producerMessage);
//                    Thread.sleep( (int) Math.random() * 500 );
                }
            } catch (Exception ex) {ex.printStackTrace();}
        });
        //consumer
        Thread consumer = new Thread( () -> {
            String consumerMessage = "I am not gay you are gay!";
            try {
                while (true) {
                    System.out.println("---------------------->");
                    System.out.println("Consumer sent Message ->  "+ consumerMessage);
                    consumerMessage = exchanger.exchange(consumerMessage);
                    System.out.println("Consumer received Message -> "+ consumerMessage);
//                    Thread.sleep( (int) Math.random() * 500 );
                }
            } catch (Exception ex) {ex.printStackTrace();}
        });


        producer.start();
        consumer.start();

        try {
            Thread.sleep(500);
            producer.interrupt();
            consumer.interrupt();
        } catch (Exception ex) {ex.printStackTrace();}
    }

}