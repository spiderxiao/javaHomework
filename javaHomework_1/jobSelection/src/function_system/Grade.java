package function_system;

import java.util.Scanner;

public class Grade
{
    public double javaScore;
    public double sqlScore;
    public double htmlScore;
    public double totalPoint;
    public double averageScore;
    public String name;

    public Grade inputScore()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("姓名：");
        this.name = sc.next();

        System.out.print("java成绩：");
        this.javaScore = 0;
        //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.javaScore = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }

        System.out.print("sql成绩：");
        this.sqlScore = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.sqlScore = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }

        System.out.print("html成绩：");
        this.htmlScore = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.htmlScore = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }

        this.averageScore = (javaScore + htmlScore + sqlScore) / 3;
        this.totalPoint = javaScore + htmlScore + sqlScore;

        return this;

    }

    public void outputScore()
    {

        System.out.println("姓名：" + this.name);

        System.out.printf("java成绩：%.1f\n", this.javaScore);

        System.out.printf("sql成绩：%.1f\n", this.sqlScore);

        System.out.printf("html成绩：%.1f\n", this.htmlScore);

        System.out.printf("总分：%.1f\n", this.totalPoint);

        System.out.printf("平均分：%.2f\n", this.averageScore);
    }
}