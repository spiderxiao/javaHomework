package function_game;

public class BigIntJudge extends Thread
{
    private long x;

    public BigIntJudge(long x)
    {
        this.x = x;
    }

    @Override
    public void run()
    {
        for (int i = 2; i * i <= x; i++)
        {
            if (x % i == 0)
            {
                System.out.println(x + "不是素数");
                return;
            }
        }
        System.out.println(x + "是素数");

    }
}
