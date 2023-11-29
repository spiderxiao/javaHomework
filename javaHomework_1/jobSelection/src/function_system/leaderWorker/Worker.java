package function_system.leaderWorker;

import java.util.concurrent.locks.ReentrantLock;

public class Worker extends Thread
{
    private String name;
    private String task;
    private Leaders leaders;
    private static final ReentrantLock lock = new ReentrantLock();
    public Worker(String task ,Leaders leaders)
    {
        this.name = "张三";
        this.task = task;
        this.leaders = leaders;
    }


    @Override
    public void run()
    {
        lock.lock();
        try {

            Thread.sleep(2000);
            leaders.callback();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
}
