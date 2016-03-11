/**
 * Created by hemanth on 11/03/2016.
 */
public class Mains {

    public static void main(String[] args) {
        BlockingQueueBox b = new BlockingQueueBox();
        Producer p1 = new Producer(b);
        Consumer c1 = new Consumer(b);
        Producer p2 = new Producer(b);
        Consumer c2 = new Consumer(b);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished successfully!");
    }

}