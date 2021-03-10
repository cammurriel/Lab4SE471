package AgentDemo;

import static java.lang.Thread.sleep;

public class FBI_Agent implements runnable, Agent_IF {
    private boolean workingInProgress;
    private String myFootPrint;

    FBI_Agent()
    {
        myFootPrint = "";
        workingInProgress = false;
    }
    FBI_Agent(String footprint)
    {
        this.myFootPrint = footprint;
    }

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
    }
private void processing()
{

}

    @Override
    public void startTask() {

    }

    @Override
    public void stopTask() {

    }

    @Override
    public void setTaskID(int id) {

    }
}
