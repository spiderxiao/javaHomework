package function_system.leaderWorker;

public abstract class Leaders
{
    private String name;

    public Leaders(String name)
    {
        this.name = name;
    }

    public void setTask(String task)
    {
        Worker worker = new Worker(task, this);
        worker.start();
    }
    abstract public void callback();

}
