package AgentDemo;
import PoolPattern.ObjectPool;

public class CIA_AgentApp {

    public static void main(String[] args) {
     ObjectPool server = ObjectPool.getPoolInstance(new CIA_Agent_Creator(),5);

    for (int i = 0; i < 10; i++)
        {
            Thread client = new Thread(new TaskRequester(server));
            client.start();
        }
    }
}
