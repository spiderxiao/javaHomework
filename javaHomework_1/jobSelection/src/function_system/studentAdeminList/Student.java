package function_system.studentAdeminList;

import java.util.Scanner;

public class Student
{
    private String name;
    private int age;
    private String studentNumber;

    public String getStudentNumber()
    {
        return studentNumber;
    }

   public Student()
    {
        System.out.println("姓名：");
        Scanner sc = new Scanner(System.in);
        setName(sc.next());

        System.out.println("年龄：");
        //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt())
            {
                setAge(sc.nextInt());
                if (age < 0 || age > 130)
                {
                    System.out.println("请输入正确年龄！");
                    continue;
                }
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }

        System.out.println("学号:");
        setStudentNumber(sc.next());


    }

    public Student(String name, int age, String studentNumber)
    {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
    }
    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString()
    {
        String res = "姓名:" + name + " 年龄：" + age + " 学号:" + studentNumber;
        return res;
    }
}
