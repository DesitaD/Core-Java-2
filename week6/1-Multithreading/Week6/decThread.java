
public  class decThread extends Thread{
    final private Counter newCounter;
    
    public decThread(Counter c){
        this.newCounter=c;
    }
    
    public void run(){
        newCounter.decrement();
    }
}
