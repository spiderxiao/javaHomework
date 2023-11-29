package studentAdmainMysql;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CourseOperation {
    public static void shoeMenu() {
        System.out.println("课程信息管理");
        System.out.println("--------------------------------");
        System.out.println("课程信息添加————1");
        System.out.println("课程信息修改————2");
        System.out.println("课程信息删除————3");
        System.out.println("课程信息查询————4");
        System.out.println("退出————0");
    }

    public static void addCourse(){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:\n课程名称:");
        Course course = null;
        String name = sc.next();

        System.out.println("学分:");

        double score = 0;
        while (true) {
            if (sc.hasNextDouble()) {
                score = sc.nextDouble();
                if (score >= 0)
                    break;
            } else {
                System.out.println("请输入大于0的数字！");
                sc.next();
            }
        }

        course = new Course(0, name, score);

        CourseDao.insert(course);

        printCourses(CourseDao.findCourse(""));

    }


    //删除
    public static void delete() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程编号：");

        int no = 0;
        while (true) {
            if (sc.hasNextInt()) {
                no = sc.nextInt();
                if (no >= 0)
                    break;
            } else {
                System.out.println("请重新输入！");
                sc.next();
            }
        }

        Course s = CourseDao.getOneByNo(no);
        if (s == null) {
            System.out.println("没有这个课程！");
        } else {
            CourseDao.delete(no);
        }
        printCourses(CourseDao.findCourse(""));
    }


    //更新
    public static void edit() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程编号：");

        int no = 0;
        while (true) {
            if (sc.hasNextInt()) {
                no = sc.nextInt();
                if (no >= 0)
                    break;
            } else {
                System.out.println("请重新输入！");
                sc.next();
            }
        }

        Course c = CourseDao.getOneByNo(no);
        if (c == null) {
            System.out.println("没有这个课程！");
        } else {
            System.out.println("请输入:\n课程名称:");
            String name = sc.next();

            System.out.println("学分:");
            double score = 0;
            while (true) {
                if (sc.hasNextDouble()) {
                    score = sc.nextDouble();
                    if (score >= 0)
                        break;
                } else {
                    System.out.println("请输入大于0的数字！");
                    sc.next();
                }
            }
            Course course = new Course(c.getNo(), name, score);
            CourseDao.update(course);
            printCourses(CourseDao.findCourse(""));
        }

    }


    //查询
    public static void search() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询条件");
        String key = sc.nextLine();
        printCourses(CourseDao.findCourse(key));
    }


    //打印所有课程
    public static void printCourses(List<Course> results) {
        System.out.println("编号\t\t课程\t\t学分");
        System.out.println("--------------------------------------------------");
        if (results.size() > 0) {

            Iterator<Course> iterator = results.iterator();
            while (iterator.hasNext()) {
                Course s = iterator.next();
                System.out.println(s);
            }
        } else {
            System.out.println("没有课程信息！！");
        }
        System.out.println("--------------------------------------------------");
    }
}
