class ThreadCreation {
    public static void main(String[] args) {
        Thread extendedClassThread = new ThreadCreationByExtendingClass();
        extendedClassThread.start();

        Thread implemetedImplThread = new Thread(new ThreadCreationByImplementation());
        implemetedImplThread.start();

        Thread annonymusFunction = new Thread( () -> {
            System.out.println("Thread created by annonymus function : "+ Thread.currentThread().getName());
            int i=99999;
            while (i==0) i--;
        } );
        annonymusFunction.start();

        System.out.println("Main Thread end! : " + Thread.activeCount());
    }

    // Extend Thread class
    static class ThreadCreationByExtendingClass extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Thread created by extending Thread class : " + Thread.currentThread().getName());
                Thread.sleep(2500);
            } catch ( Exception ex ) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Implementation Method!
    static class ThreadCreationByImplementation implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread created by implementing Runnable Interface : " + Thread.currentThread().getName());
                Thread.sleep(2500);
            } catch (Exception ex ) {
                Thread.currentThread().interrupt();
            }
        }
    }


}