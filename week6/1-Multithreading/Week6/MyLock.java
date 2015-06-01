
public class MyLock {
    private boolean isLocked= false;
    
    public synchronized void lock(){
        while(isLocked){
            try {
                wait();
            } catch (InterruptedException e) {
          
                e.printStackTrace();
            }
        }
        
        isLocked=true;
    }
    
    public synchronized void unLock(){
        isLocked=false;
        notifyAll();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
