/**
 * Created by hemanth on 11/03/2016.
 */
public class Producer extends Thread {
    private BlockingQueueBox box;

    public Producer(BlockingQueueBox box) {
        this.box = box;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        String[] msgs = {"Raj","Vijay","Hemanth", "Darwin", "DeeP"};

        for(String message : msgs) {
            box.put(message);
        }

        box.put("DONE");
    }
}