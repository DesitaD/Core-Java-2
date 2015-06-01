package toDoList;

import java.util.PriorityQueue;

public class ToDoList {
    
    PriorityQueue<Task> priQueue = new PriorityQueue<Task>();
    private int remainingHours;
    
    
    
    public int getRemainingHours() {
        return remainingHours;
    }

    public void setRemainingHours(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    public ToDoList(int remainingHours) {
        super();
        this.remainingHours = remainingHours;
    }

    public void add(Task t){
        priQueue.offer(t);
    }
    
    public void markFinished(Task t){
        if(t.isChecked()){
            System.out.println("The task is alreday done!!!");
        }
        else{
            t.setChecked(true);
        }
       
    }
    
    public void markCancelled(Task t){
        t.setChecked(false);
        priQueue.remove(t);
       
    }
    
    public Task getTop(){
       return this.priQueue.peek();
    }
    
    public boolean canFinish(){
        int neededTime=0;
        for(Task task:priQueue){
            neededTime+=task.getTime();
            
        }
       if(remainingHours>neededTime){
           return true;
       }
       else{
           return false;
       }
    }
    
    public  int getRemainigTime(){
        int neededTime=0;
        for(Task task:priQueue){
            neededTime+=task.getTime();
            
        }
        int temp = remainingHours-neededTime;
        return temp;
    }

}
