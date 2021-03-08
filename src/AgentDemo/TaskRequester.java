package AgentDemo;

import PoolPattern.ObjectPool;

import static java.lang.Thread.sleep;

public class TaskRequester implements runnable{
ObjectPool server;
public TaskRequester(ObjectPool p)
{
    this.server = p;
}

    @Override
    public void run() throws InterruptedException {
        Agent_IF agent = (Agent_IF)server.waitForObject();
        agent.startTask();
        sleep(2000);
        agent.startTask();
        server.release(agent);
    }
}
