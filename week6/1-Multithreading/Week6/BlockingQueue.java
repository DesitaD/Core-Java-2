import java.util.LinkedList;
import java.util.Queue;


public class BlockingQueue {
    private MyLock lock=new MyLock();
     private Queue<Integer> blockingQueue= new LinkedList<Integer>();
     BlockingQueue(){
         
     }
     
     public synchronized void addMethod(){
         lock.lock();
         System.out.println("Additionnn!!!");
             for(int i=0; i<=1000;i++){
                 blockingQueue.add(i);
                 notify();
             }
         lock.unLock();       
     }
     
     public synchronized void pollMethod(){
         lock.lock();
         System.out.println("do the method");
                 System.out.println("start the thread");
                 if (!blockingQueue.isEmpty()){
                     for (int i = 0; i < blockingQueue.size(); i++) {
                        System.out.println(blockingQueue.poll()); 
                     }
                 }
                 else{
                     try {
                         System.out.println("Waiting because is empty///////");
                        wait();
                     } catch (InterruptedException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                     }
                 }
         lock.unLock();
         System.out.println("finish the method");
         
     }

     public static void main(String[] args) {
        BlockingQueue bq= new BlockingQueue();
       // bq.addMethod();
       //bq.pollMethod();
     
        Thread addT= new addThread(bq);
       addT.start();
       pollThread pollT=new pollThread(bq);
       pollT.setPriority(9);
       pollT.start();

    }

}
