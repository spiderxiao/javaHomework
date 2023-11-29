package function_system;

import java.util.Arrays;
import java.util.Scanner;

public class GradeAdemin
{
    public Grade[] allScore;
    public int studentNumber = 0;

    public void set_allScore()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数：");
        int n = 0;

        //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt())
            {
                n = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入整数！");
                sc.next();
            }
        }

//        Grade[] temp = new Grade[n + this.studentNubber];
//
//        for (int i = 0; i < this.studentNubber; i++)
//            temp[i] = this.allScore[i];
//
//        this.allScore = temp;
        if (this.studentNumber == 0)
            this.allScore = new Grade[n];
        else
        this.allScore = Arrays.copyOf(this.allScore, n + this.studentNumber);

        for (int i = this.studentNumber; i < this.studentNumber + n; i++)
        {
            Grade t = new Grade();
            this.allScore[i] = t.inputScore();

        }
        this.studentNumber += n;
    }


    //打印所有学生成绩，并选择排序方式
    public void outputAllScore()
    {
        System.out.printf("%-6s", "姓名");

        System.out.printf("%-6s", "java");

        System.out.printf("%-6s", "sql");

        System.out.printf("%-6s", "html");

        System.out.printf("%-6s", "总分");

        System.out.printf("%-6s","平均分");
        System.out.println();
        for (int i = 0; i < this.studentNumber; i++)
        {
            System.out.printf("%-6s", this.allScore[i].name);
            System.out.printf("%-6.1f", this.allScore[i].javaScore);
            System.out.printf("%-6.1f", this.allScore[i].sqlScore);
            System.out.printf("%-6.1f", this.allScore[i].htmlScore);
            System.out.printf("%-6.1f", this.allScore[i].totalPoint);
            System.out.printf("%-6.2f", this.allScore[i].averageScore);
            System.out.println();
        }

        System.out.println("选择排序方式：1——升序；2——降序；3——退出");
            Scanner sc = new Scanner(System.in);
            int n;


            //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt() )
            {
                n = sc.nextInt();
                if (n == 1 || n == 2 || n == 3)
                break;
                else
                    System.out.println("无此选项，请重新输入！");

            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }

        if (n == 3)
            return;

            if (n == 1 || n == 2)
                this.ascendingOrder(n);
        this.outputAllScore();


    }

    //升/降 序排列
    public void ascendingOrder(int n)
    {
        for (int i = 0; i < this.studentNumber - 1; i++)
        {
            for (int j = i + 1; j < this.studentNumber; j++)
            {
                if ((allScore[i].totalPoint > allScore[j].totalPoint && n == 1) ||
                        (allScore[i].totalPoint < allScore[j].totalPoint && n == 2))
                {
                    Grade t = allScore[i];
                    allScore[i] = allScore[j];
                    allScore[j] = t;
                }
            }
        }
    }


//    //降序排列
//
//    public void descendingOrder()
//    {
//        for (int i = 0; i < this.studentNumber - 1; i++)
//        {
//            for (int j = i + 1; j < this.studentNumber; j++)
//            {
//                if (allScore[i].totalPoint < allScore[j].totalPoint)
//                {
//                    Grade t = allScore[i];
//                    allScore[i] = allScore[j];
//                    allScore[j] = t;
//                }
//            }
//        }
//    }

    //通过姓名查找学生
    public Grade find_student()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生姓名:");
        String target_name = sc.next();
        for (int i = 0; i < studentNumber; i++)
        {
            if (allScore[i].name.equals(target_name))
            {
                return allScore[i];
            }
        }
        return null;
    }

}