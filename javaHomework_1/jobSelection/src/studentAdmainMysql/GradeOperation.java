package studentAdmainMysql;

import java.util.List;
import java.util.Scanner;

public class GradeOperation
{
    public static void studentSelectCourse()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学号：");
        int stuNo = sc.nextInt();

        Student s = StudentDao.getOneByNo(stuNo);

        if (s != null) {

            while (true) {

                System.out.println(s);
                System.out.println("--------已选课程------------");
                List<Course> selectCourses = GradeDao.findCoursesSelectBystudent(s, true);

                CourseOperation.printCourses(selectCourses);
                System.out.println("-----------------------------");

                System.out.println("--------未选课程------------");
                List<Course> noSelectCourses = GradeDao.findCoursesSelectBystudent(s, false);

                CourseOperation.printCourses(noSelectCourses);

                System.out.println("-----------------------------");

                System.out.println("输入课程编号：-1——退出");

                int courseNo = 0;
                while(true)
                {
                    if (sc.hasNextInt())
                    {
                        courseNo = sc.nextInt();
                        break;
                    }
                    else {
                        System.out.println("请重新输入！");
                        sc.next();
                    }
                }


                if (courseNo == -1) {

                    break;

                }

                Course c = CourseDao.getOneByNo(courseNo);
                if (c != null)
                {

                    Grade g = GradeDao.getOneByStuAndCourse(s, c);

                    if (g != null) {

                        System.out.println("该课程已经被选择");

                    } else {

                        Grade grade = new Grade();
                        grade.setStudent(s);
                        grade.setCourse(c);
                        GradeDao.insert(grade);
                    }

                }
                else {

                    System.out.println("没有这门课！");

                }

            }

        }
        else {

            System.out.println("没有这个学生！");

        }

    }


//成绩录入
    public static void inputGrade(){

        Scanner sc = new Scanner(System.in);
        //打印所有课程
        CourseOperation.printCourses(CourseDao.findCourse(""));

        System.out.println("输入课程编号");

        int courseNo = sc.nextInt();

        Course c = CourseDao.getOneByNo(courseNo);

        if (c != null) {

            // 显示课程的所有成绩记录

            while (true) {

                List<Grade> grades = GradeDao.findGradesByCourse(c);

                printCourseGrade(c, grades);

                System.out.println("请输入学生编号:，-1退出");

                int stuNo = sc.nextInt();

                if (stuNo == -1) {

                    break;

                } else {

                    Student stu = StudentDao.getOneByNo(stuNo);

                    if (stu != null) {

                        Grade g = GradeDao.getOneByStuAndCourse(stu, c);

                        if (g != null) {

                            System.out.println("输入" + stu.getName() + "的成绩：");

                            double m = 0;
                            while(true)
                            {
                                if (sc.hasNextDouble())
                                {
                                    m = sc.nextDouble();
                                    if (m >= 0)
                                        break;
                                }
                                else {
                                    System.out.println("请重新输入！");
                                    sc.next();
                                }
                            }


                            GradeDao.updateGrade(m, g.getNo());

                        }
                        else {

                            System.out.println(stu.getName() + "没有选这门课！");

                        }

                    } else {

                        System.out.println("没有这个学生！");

                    }

                }

            }



        } else {

            System.out.println("没有这门课程");

        }



    }




//打印课程成绩表
    public static void printCourseGrade(Course c, List<Grade> results) {

        System.out.println("课程：" + c.getName());

        System.out.println("学号\t\t学生名字\t\t成绩");

        System.out.println("----------------------------------------");

        for (Grade g : results) {

            System.out.println(g.getStudent().getNo() + "\t\t" + g.getStudent().getName() + "\t\t" + g.getGrade());

        }

        System.out.println("----------------------------------------");

    }



//打印学生成绩表
    public static void printStudentGrade(Student s, List<Grade> results) {

        System.out.println("学生：" + s.getName());

        System.out.println("课程编号\t\t课程名字\t\t成绩");

        System.out.println("----------------------------------------");

        double sum=0;

        for (Grade g : results) {

            System.out.println(g.getCourse().getNo() + "\t\t" + g.getCourse().getName() + "\t\t" + g.getGrade());

            if(g.getGrade()>=60) {

                sum=sum+g.getCourse().getScore();

            }

        }

        System.out.println("已修学分："+sum);

        System.out.println("----------------------------------------");



    }




//查询学生成绩
    public static void queryGradeByStudent() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");

        int stuNo = sc.nextInt();

        Student s = StudentDao.getOneByNo(stuNo);

        if(s!=null) {

            List<Grade> grades = GradeDao.findGradesByStudent(s);

            printStudentGrade(s, grades);

        }else {

            System.out.println("没有这个学生！！");

        }

    }




//菜单
    public static void gradeMenu() {
        System.out.println("成绩管理");
        System.out.println("-------------------------");
        System.out.println("1————学生选课");
        System.out.println("2————老师录入成绩");
        System.out.println("3————成绩查询");
        System.out.println("0————退出");
    }

}
