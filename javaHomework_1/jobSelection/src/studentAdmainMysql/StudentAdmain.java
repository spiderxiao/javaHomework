package studentAdmainMysql;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentAdmain
{
    public static void showMenu()
    {
        System.out.println("学生信息管理");
        System.out.println("--------------------------------");
        System.out.println("学生信息添加————1");
        System.out.println("学生信息修改————2");
        System.out.println("学生信息删除————3");
        System.out.println("学生信息查询————4");
        System.out.println("退出————0");
    }

    //学生信息的新增
    public static void addStudent()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:\n姓名:");
        Student student = null;
        String name = sc.next();
        System.out.println("专业:");
        String major = sc.next();
        student = new Student(0, name, major);

        StudentDao.insert(student);

        printStudents(StudentDao.findStudent(""));

    }


    //打印所有学生信息
    public static void printStudents(List<Student> results)
    {
        System.out.println("编号\t\t姓名\t\t专业");
        System.out.println("--------------------------------");
        if (results.size() > 0)
        {
           for (Student s : results)
           {
               System.out.println(s);
           }
        }
        else {
            System.out.println("没有学生信息");
        }
    }


    //学生信息的查询显示
    public static void search() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询条件:");
        //输入空格查询所有
        String key = sc.nextLine();
        printStudents(StudentDao.findStudent(key));
    }

    //学生信息的编辑
    public static void edit() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生编号：");
        int no = sc.nextInt();
        Student s = StudentDao.getOneByNo(no);

        if (s == null) {
            System.out.println("没有这个学生！");
        } else {
            System.out.println("请输入:\n姓名:");
            s.setName(sc.next());
            System.out.println("专业：");
            s.setMajor(sc.next());
            StudentDao.update(s);
            printStudents(StudentDao.findStudent(""));
        }
    }

    //学生信息的删除
    public static void delete() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生编号：");
        int no = sc.nextInt();
        Student s=StudentDao.getOneByNo(no);
        if (s == null) {
            System.out.println("没有这个学生！");
        } else {
            StudentDao.delete(no);
        }
        printStudents(StudentDao.findStudent(""));
    }

}



