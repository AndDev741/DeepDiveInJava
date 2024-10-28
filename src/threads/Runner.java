package threads;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MultiThread("Thread 1"));
        Thread thread2 = new Thread(new MultiThread("Thread 2"));
        Thread thread3 = new Thread(new MultiThread("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();

        for(int i = 0;i < 10; i++){
            System.out.println("Main thread: " + i);
        }

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Threads finished");


    }
}
