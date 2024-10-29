package threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args){
        for(int i = 0; i <= 5; i++){
            Thread thread = new Thread(new Task(i));
            thread.start();
        }
    }

    static class Task implements Runnable {
        private final int id;

        Task(int id){
            this.id = id;
        }

        @Override
        public void run() {
            try{
                System.out.println("Thread: " + id + " Waiting permission.");
                semaphore.acquire();
                System.out.println("Thread: " + id + " is in the section");
                //If we don't release we make a deadlock, where the other threads wait forever the 2 first release.
                semaphore.release();
                System.out.println("Thread: " + id + " was released");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
