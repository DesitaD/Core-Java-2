
public class pollThread extends Thread{
    final private BlockingQueue bQueue;
    
    public  pollThread(BlockingQueue b){
        this.bQueue=b;
        
    }
   
    public void run(){
        bQueue.pollMethod();
    }
}
