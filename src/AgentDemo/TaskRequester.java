package AgentDemo;

import PoolPattern.ObjectPool;

import static java.lang.Thread.sleep;

public class TaskRequester implements Runnable{
private ObjectPool server;
public TaskRequester(ObjectPool p)
{
    this.server = p;
}

    @Override
    public void run() {
        Agent_IF agent = null;
        try {
            agent = (Agent_IF)server.waitForObject();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.startTask();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        agent.stopTask();
        server.release(agent);
    }
}
