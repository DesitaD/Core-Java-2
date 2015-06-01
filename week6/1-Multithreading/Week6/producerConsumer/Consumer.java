package producerConsumer;

public class Consumer implements Runnable{
    
    private BlockingQueue bqueue;
    
    Consumer(BlockingQueue bq){
        this.bqueue=bq;
    }

    @Override
    public void run() {
       // while(true){
        try {
            System.out.println("Consume:");
            bqueue.pollMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   // }

}

