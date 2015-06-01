package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

import javax.lang.model.element.Element;

public class BlockingQueue {
   
    private Queue<Integer> blockingQueue= new LinkedList<Integer>();
    private int limit;
    BlockingQueue(){
        
    }
    
    private BlockingQueue(int limit){
        this.limit=limit;
    }
    
  
    public synchronized void addMethod(int element) throws InterruptedException{
        synchronized (blockingQueue){
            while(blockingQueue.size()==limit){
            System.out.println("The queue is full!");
            blockingQueue.wait();
           
        }
           synchronized (blockingQueue) {
            blockingQueue.add(element);
            notifyAll();
        }
       }
    }
    
    public synchronized void pollMethod() throws InterruptedException{
       
       synchronized (blockingQueue){
           while(blockingQueue.isEmpty()) {
            System.out.println("The queue is empty!");
            blockingQueue.wait();   
        }
       }
           synchronized (blockingQueue) {
            System.out.println("Consumer:"+ blockingQueue.poll());
            notifyAll();
            
        }        
    }
    
    

    public static void main(String[] args) {
       BlockingQueue bq= new BlockingQueue(10);
    
       Producer pollT=new Producer(bq);
       pollT.run();
     Consumer cons= new Consumer(bq);
     cons.run();
      

   }

}
