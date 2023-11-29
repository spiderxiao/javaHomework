package studentAdmainMysql;

import java.util.Scanner;

public class Student
{
    static int count = 0;
    private String name;

    private String major;
    private int no;//编号

    public int getNo()
    {
        return no;
    }

   public Student()
    {
        System.out.println("姓名：");
        Scanner sc = new Scanner(System.in);
        setName(sc.next());

        System.out.println("专业：");
        setMajor(sc.next());

        System.out.println("学号:");

        int tt = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                tt = sc.nextInt();
                if (tt >= 0)
                    break;
            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }

        setNo(tt);
        count += 1;


    }

    public Student(int no, String name, String major)
    {
        this.name = name;
        this.major = major;
        this.no = no;
    }
    public String getMajor()
    {
        return major;
    }

    public String getName()
    {
        return name;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNo(int no)
    {
        this.no = no;
    }

    @Override
    public String toString()
    {
        String res = "编号：" + no +"姓名:" + name + " 专业：" + major;
        return res;
    }
}
