package AgentDemo;

import PoolPattern.ObjectCreation_IF;

public class CIA_Agent_Creator implements ObjectCreation_IF {
    private String[] footprints = {"@","#","$","*",".","?"};
    private int index;
    private int taskID;
    public Object create()
    {
        CIA_Agent agent = new CIA_Agent(footprints[index++]);
        //new Thread(agent).start();
        return agent;
    }
    public int getIndex()
    {
        return index;
    }
    public int getTaskID()
    {
        return taskID;
    }
}
