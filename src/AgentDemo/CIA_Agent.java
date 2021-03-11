package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent implements Runnable, Agent_IF{
    private boolean workingInProgress;
    private String myFootPrint;
    private int taskID;
    CIA_Agent()
    {
        workingInProgress = false;
        myFootPrint = "";
    }
    public String getMyFootPrint()
    {
        return myFootPrint;
    }

    public boolean getWorkingInProgress()
    {
        return workingInProgress;
    }

    CIA_Agent(String footprint)
    {
        this.myFootPrint = footprint;
    }
    @Override
    public void run() {
        while(true)
        {
           if(workingInProgress)
           {
               try {
                   sleep(500);
                   processing();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //System.out.println("FootPrint" + myFootPrint);
           }
           else
           {
               try {
                   sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            }
        }//end of CIA_Agent

        public void startTask()
        {
            workingInProgress = true;
            //System.out.println("Agent " + getMyFootPrint() + " has task");
        }
        public void stopTask()
        {
            workingInProgress = false;
            //System.out.println("Agent " + getMyFootPrint() + " has completed the task");
        }

    @Override
    public void setTaskID(int id) {

        taskID = id;
    }

    private void processing()
    {
        System.out.println("Processing CIA_Agent" + myFootPrint + " " + taskID);
    }

    }
