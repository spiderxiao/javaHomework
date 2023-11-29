package function_system.studentAdeminList;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentAdemin
{
    private List<Student> studentList;


    public StudentAdemin()
    {
        studentList = new ArrayList<>();
    }
    //修改
    public void changeData(int num)
    {
        if (num >= studentList.size() || num < 0)
            System.out.println("查无此人!");
        else
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("原信息为:");
            System.out.println(studentList.get(num));
            System.out.println("修改为：");

            System.out.println("姓名：");
            studentList.get(num).setName(sc.next());


            System.out.println("年龄：");


            //保证输入为整数
            while(true)
            {
                if (sc.hasNextInt())
                {
                    studentList.get(num).setAge(sc.nextInt());
                    if (studentList.get(num).getAge() < 0 || studentList.get(num).getAge() > 130)
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
            System.out.println("学号：");
            studentList.get(num).setStudentNumber(sc.next());
        }
    }

    //按编号查找
    public void find(int num)
    {
        if (num >= studentList.size() || num < 0)
            System.out.println("查无此人!");
        else
            System.out.println(studentList.get(num));
    }

    //模糊查找
    public void findLike(String name)
    {
        int len = name.length();
        int res = 0;

        if (!studentList.isEmpty())
        for (int i = 0; i < studentList.size(); i++)
        {
            String temp = studentList.get(i).getName().substring(0, len);

            if (temp.equals(name))
            {
                res++;
                System.out.println(studentList.get(i).getName() + " " + studentList.get(i).getAge() +
                        " " + studentList.get(i).getStudentNumber());
            }

        }

        if (res == 0)
            System.out.println("未找到！");
    }

    //添加学生
    public void addStudent(Student student)
    {
        studentList.add(student);
    }

    //保存文件
    public void savaFile(String fileName)
    {

        try {
            FileWriter writer = new FileWriter(fileName, false);

            if (!studentList.isEmpty())
            for (Student s : studentList)
            {
                String t1 = s.getName();
                int t2 = s.getAge();
                String t3 = s.getStudentNumber();
                writer.write(t1 + " " + t2 + " " + t3 + "\n");
            }
            System.out.println("保存成功！");
            writer.close();
        } catch (IOException e) {
            System.out.println("保存失败");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    //加载文件
    public void lodeFile(String fileName)
    {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = " ";

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] s = line.split(" ");
                Student tem = new Student(s[0], Integer.parseInt(s[1]), s[2]);
                studentList.add(tem);
            }

            System.out.println("读取成功");
            reader.close();
        } catch (IOException e) {
            System.out.println("读取失败");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //功能菜单
    public void showMenu()
    {
        System.out.println("学生信息添加——1");
        System.out.println("学生信息修改——2");
        System.out.println("学生信息删除——3");
        System.out.println("学生信息查询——4");
        System.out.println("退出——0");
    }

    //删除
    public void removeStudent(int n)
    {
        studentList.remove(n);
    }
}
