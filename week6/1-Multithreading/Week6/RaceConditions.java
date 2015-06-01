import java.util.concurrent.atomic.AtomicInteger;


public class RaceConditions {

    public static void main(String[] args) {
        Runnable rcount= new Runnable0();
        Thread first= new Thread(rcount);
        first.start();
        Thread second=new Thread(rcount);
        second.start();
        try{
            first.join();
            second.join();
        }catch(InterruptedException ie){
            ie.printStackTrace();            
        }
        Runnable0  res= new Runnable0();
       // System.out.println(res.increment());
        System.out.println(res.atomicIncremet());

    }

}

class Runnable0 implements Runnable {
    private static int counter=0;
    private static AtomicInteger atomicCounter= new AtomicInteger(0);
    @Override
    public void run() {
//        synchronized(this){
//            for (int i=0;i<=2000000;i++){
//            counter++;
//            }
//        }
 //      increment();
       atomicIncremet();
    }
    public int get(){
        return counter;
    }
    public synchronized int increment(){
        for (int i=0;i<2000000;i++){
            counter++;
            }
        return counter;
    }
    
    public AtomicInteger atomicIncremet(){
        for (int i=0;i<2000000;i++){
            atomicCounter.incrementAndGet();
            }
        return atomicCounter;
    }

   
}