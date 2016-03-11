/**
 * Created by hemanth on 11/03/2016.
 */
public class BlockingQueueBox {
    String[] messagequeue;
    static int push=0;
    static int pop=0;

    public BlockingQueueBox() {
        messagequeue=new String[10];


    }
    public synchronized void put(String messagein) {
        while(messagequeue[push]!=null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.messagequeue [push]= messagein;
        push=(++push%10);
        notifyAll();
        System.out.println("putted" +messagein);
        return;

    }

    public String take() {
        synchronized(this) {
            while((push==pop)&& (messagequeue[pop]==null)) {
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            String rv =messagequeue[pop];
            messagequeue[pop] = null;
            pop= (++pop)%10;
            notifyAll();
            System.out.println("Returned" +rv);
            return rv;
        }
    }
}