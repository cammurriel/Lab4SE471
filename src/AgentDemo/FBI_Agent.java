package AgentDemo;

import static java.lang.Thread.sleep;

public class FBI_Agent implements Runnable, Agent_IF {
    private boolean workingInProgress;
    private String myFootPrint;
    private int taskID;

    FBI_Agent()
    {
        myFootPrint = "";
        workingInProgress = false;
    }
    FBI_Agent(String footprint)
    {
        this.myFootPrint = footprint;
    }

    public String getMyFootPrint() {
        return myFootPrint;
    }

    public void run() {
        while(true)
        {
            if(workingInProgress)
            {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(myFootPrint);
            }
            else
            {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void processing(){
        System.out.println("Processing FBI_Agent please wait....");
    }

    public int getTaskID() {
        return taskID;
    }

    @Override
    public void startTask() {
        workingInProgress = true;
        System.out.println("Agent " + getMyFootPrint() + "has task");
    }

    @Override
    public void stopTask() {
        workingInProgress = false;
        System.out.println("Agent " + getMyFootPrint() + "has complete the task");
    }

    @Override
    public void setTaskID(int id) {
    taskID = id;
    }
}
