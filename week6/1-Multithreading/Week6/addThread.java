
public class addThread extends Thread{
    final private BlockingQueue bQueue;
    
    public addThread(BlockingQueue b){
        this.bQueue=b;
        
    }
    
    public void run(){
        bQueue.addMethod();
       
    }
}
