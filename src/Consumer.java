/**
 * Created by hemanth on 11/03/2016.
 */
public class Consumer extends Thread {
    private BlockingQueueBox box;

    public Consumer(BlockingQueueBox box) {
        this.box = box;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        for(String message = box.take(); !message.equals("DONE"); message = box.take()) {
            System.out.println(message);
        }
    }
}