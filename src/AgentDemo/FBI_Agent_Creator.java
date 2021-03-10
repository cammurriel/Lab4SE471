package AgentDemo;

import PoolPattern.ObjectCreation_IF;

public class FBI_Agent_Creator implements ObjectCreation_IF {
    private String[] footprints = {"@","#","$","*",".","?"};
    private int index;

    public String[] getFootprints()
    {
        return footprints;
    }
    public int getIndex()
    {
        return index;
    }
    public Object create() {
        FBI_Agent agent = new FBI_Agent(footprints[index++]);
        return agent;
    }


}
