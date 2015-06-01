
public class Counter {
    private MyLock mlock= new MyLock();
    private int count;
    Counter(){
        count=0;
    }
     public void increment(){
         mlock.lock();
         int newCount=++count;
         System.out.println(newCount);
         mlock.unLock();
         //return newCount;
     }
     
     public int decrement(){
         mlock.lock();
         int newCount=--count;
         System.out.println(newCount);
         mlock.unLock();
         return newCount;
     }
     
//     class incThread extends Thread{
//         final private Counter newCounter;
//         
//         public incThread(Counter c){
//             this.newCounter=c;
//         }
//         
//         public void run(){
//             newCounter.increment();
//         }
//     }
     

     
    public static void main(String[] args) {
       Counter cnt=new Counter();
       Thread inc= new incThread(cnt);
       inc.start();
       Thread dec = new decThread(cnt);
       dec.setPriority(8);
       dec.start();
       
       

    }

}
