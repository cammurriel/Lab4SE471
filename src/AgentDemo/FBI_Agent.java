package AgentDemo;

public class FBI_Agent implements runnable {
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

    public void run()
    {

    }

}
