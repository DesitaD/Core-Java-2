
 public class incThread extends Thread{
         final private Counter newCounter;
         
         public incThread(Counter c){
             this.newCounter=c;
         }
         
         public void run(){
             newCounter.increment();
         }
     }