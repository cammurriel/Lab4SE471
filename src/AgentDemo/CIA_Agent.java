package AgentDemo;

import static java.lang.Thread.sleep;

public class CIA_Agent implements Runnable, Agent_IF{
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
        }//end of CIA_Agent

        public void startTask(){workingInProgress = true;}
        public void stopTask(){workingInProgress = false;}

    @Override
    public void setTaskID(int id) {

    }

    private void processing(){
        System.out.println("Processing CIA_Agent please wait....");
    }

    }
