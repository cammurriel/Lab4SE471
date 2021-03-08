package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent implements runnable, Agent_IF{
    private boolean workingInProgress;
    private String myFootPrint;

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
    public void run() throws InterruptedException {
        while(true)
        {
           if(workingInProgress)
           {
               sleep(100);
               System.out.println(myFootPrint);
           }
           else
           {
             sleep(500);
           }
            }
        }//end of CIA_Agent

        public void startTask(){workingInProgress = true;}
        public void stopTask(){workingInProgress = false;}

    @Override
    public void setTaskID(int id) {

    }

    private void processing(){} //needs to be finished
    }
