package threads;

public class MultiThread implements Runnable {
    String threadName;

    public MultiThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 10; i++){
            System.out.println(Thread.currentThread() + " " + threadName + " Number: " + i);
        }
    }
}
