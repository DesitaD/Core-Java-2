package toDoList;

public class SleepTask extends Task {
    
    public SleepTask(){
        super();
    }
    public SleepTask(int priority){
        super(priority);
    }
    public SleepTask(float reqTime){
        super(reqTime);
    }
    public SleepTask(int priority, float reqTime){
        super(priority, reqTime);
    }
    

}
