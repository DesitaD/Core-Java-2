package producerConsumer;

public class Producer implements Runnable {
    private BlockingQueue bq;
    
    Producer(BlockingQueue b){
        this.bq=b;
    }

    @Override
    public void run() {
    //  while(true){
        for(int i=1; i<100; i++){
            try {
                System.out.println("Producer:"+ i);
                bq.addMethod(i);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
   // }
    

}
