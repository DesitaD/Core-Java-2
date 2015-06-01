package toDoList;

public class Task implements Comparable<Task> {
    protected int priority;
    protected float time;
    protected boolean isChecked;
    
    public Task() {
        this.priority = 1;
        this.time = 1;
        this.isChecked = false;
    }
    

    public Task(int priority){
        this.priority = priority;
        this.time = 1;
        this.isChecked = false;
    }
    
    public Task(float time){
        this.priority = 5;
        this.time = time;
        this.isChecked = false;
    }
    
    public Task(int priority, float time) {
        this.priority = priority;
        this.time = time;
        this.isChecked = false;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    public float getTime() {
        return time;
    }


    public void setTime(float time) {
        this.time = time;
    }


    public boolean isChecked() {
        return isChecked;
    }


    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


    @Override
    public int compareTo(Task task) {
        return -this.priority + task.priority;
       
    }
     
    
}
