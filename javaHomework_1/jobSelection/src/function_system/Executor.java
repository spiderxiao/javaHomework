package function_system;

import function_game.BigIntJudge;
import function_game.MyCalendar;
import function_game.TestIntByte;
import function_system.goods.Customer;
import function_system.goods.CustomerGoodsAdmin;
import function_system.io.CopyFile;
import function_system.io.MyWeather;
import function_system.leaderWorker.Leaders;
import function_system.studentAdeminList.Student;
import function_system.studentAdeminList.StudentAdemin;
import function_system.wareHouse.WareHouse;
import menu.Menu;
import studentAdmainMysql.CourseOperation;
import studentAdmainMysql.GradeOperation;
import studentAdmainMysql.StudentAdmain;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Executor
{
    CustomerGoodsAdmin cga = new CustomerGoodsAdmin();

    //保证输入为整数
    public static int input_judge()
    {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                n = sc.nextInt();
                if (n >= 0)
                break;
            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }
        return n;
    }
    public void carryOn() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n != 0)
        {
            Menu menu = new Menu();
            menu.main_menu();
            //保证输入为整数
            while(true)
            {
                if (sc.hasNextInt())
                {
                    n = sc.nextInt();
                    break;
                }
                else {
                    System.out.println("无此选项，请重新输入！");
                    sc.next();
                }
            }

            switch(n)
            {
                case 1: {
                    while(true) {
                        menu.work1_menu();
                        int k = 0;

                        //保证输入为整数
                        while(true)
                        {
                            if (sc.hasNextInt())
                            {
                                k = sc.nextInt();
                                break;
                            }
                            else {
                                System.out.println("无此选项，请重新输入！");
                                sc.next();
                            }
                        }

                        if (k == 0)
                            break;
                        if (k == 1) {
                            MyCalendar calendar = new MyCalendar(2022, 9);
                            calendar.show();
                        }
                        if (k == 2) {
                            System.out.println("人事管理系统");
                            System.out.println("---------------------");
                            System.out.println("1、添加用户");
                            System.out.println("2、查询用户");
                            System.out.println("0、退出系统");
                        }
                    }
                    break;
                }
                case 2:
                {
                    while(true) {
                        menu.work2_menu();
                        int k = 0;

                        //保证输入为整数
                        while(true)
                        {
                            if (sc.hasNextInt())
                            {
                                k = sc.nextInt();
                                break;
                            }
                            else {
                                System.out.println("无此选项，请重新输入！");
                                sc.next();
                            }
                        }

                        if (k == 0)
                            break;


                        //日历
                        if (k == 6) {
                            MyCalendar calendar = new MyCalendar();
                            calendar.set_date();
                            calendar.show();
                        }

                        //手机系统
                        if (k == 2)
                        {
                            Mobile mobile = new Mobile();
                            mobile.setMobile();
                            mobile.output();
                        }

                        //测试int 和 byte
                        if (k == 3)
                        {
                            TestIntByte t = new TestIntByte();
                            t.show_byte();
                            t.show_int();
                        }
                        //学生管理系统
                        if (k == 7)
                        {
                            GradeAdemin stu = new GradeAdemin();
                            while (true)
                            {
                                menu.work_2_GradeAdemin_menu();
                                int x = 0;

                                //保证输入为整数
                                while(true)
                                {
                                    if (sc.hasNextInt())
                                    {
                                        x = sc.nextInt();
                                        break;
                                    }
                                    else {
                                        System.out.println("无此选项，请重新输入！");
                                        sc.next();
                                    }
                                }
                                if (x == 1)
                                {
                                    stu.set_allScore();
                                }

                                if (x == 2)
                                {
                                    if (stu.studentNumber == 0) {
                                        System.out.println("当前无学生信息");
                                        continue;
                                    }
                                    Grade t = stu.find_student();
                                    if (t == null)
                                        System.out.println("查无此人");
                                    else
                                        t.outputScore();
                                }
                                if (x == 3)
                                {
                                    if (stu.studentNumber == 0) {
                                        System.out.println("当前无学生信息");
                                        continue;
                                    }
                                    stu.outputAllScore();
                                }

                                if (x == 0) break;

                            }
                        }


                        if (k != 6 && k != 0 && k != 2 && k != 7 && k != 3)
                        {
                            System.out.println("暂无此功能");
                        }
                    }
                    break;
                }

                case 3:
                {
                    while (true) {
                        menu.work3_menu();
                        int k1 = input_judge();
                        if (k1 < 0 || k1 > 5)
                            System.out.println("无此功能，请重新输入！");

                        if (k1 == 1) {
                            System.out.println("请选择身份【1】管理员    【2】顾客");

                            int k = input_judge();
                            if (k == 1) {
                                while (true) {
                                    cga.show();
                                    int choice = input_judge();

                                    if (choice == 1)
                                        cga.inputGoods();
                                    else if (choice == 2)
                                        cga.show_all_customer();
                                    else if (choice == 3)
                                        cga.show_all_goods();
                                    else if (choice == 0)
                                        break;
                                    else {
                                        System.out.println("无此选项，请重新输入");
                                        continue;
                                    }
                                }
                            } else if (k == 2) {

                                Customer t = cga.inputCustomerInfo();
                                while (true) {
                                    t.show();
                                    int choice = input_judge();

                                    if (choice == 1) {
                                        cga.show_all_goods();
                                        if (cga.getGoods_num() == 0) {
                                            System.out.println("当前暂无商品");
                                            continue;
                                        }
                                        t.buy();
                                    } else if (choice == 2) {
                                        t.print();
                                        break;
                                    } else {
                                        System.out.println("无此选项，请重新输入！");
                                        continue;
                                    }
                                }
                            } else {
                                System.out.println("无此功能，请重新输入！");
                                continue;
                            }
                        }

                        else if (k1 == 2)
                        {
                            System.out.println("请输入10个数");
                            BigIntJudge[] bij = new BigIntJudge[10];
                            for (int i = 0; i < 10; i++)
                            {
                                long t = 0l;
                                while(true)
                                {
                                    if (sc.hasNextLong())
                                    {
                                        t = sc.nextLong();
                                        break;
                                    }
                                    else {
                                        System.out.println("无此选项，请重新输入！");
                                        sc.next();
                                    }
                                }

                                bij[i] = new BigIntJudge(t);
                            }

                            for (int i = 0; i < 10; i++)
                            {
                                bij[i].start();
                            }

                            for (int i = 0; i < 10; i++)
                            {
                                bij[i].join();
                            }



                            System.out.println("所有线程已执行完毕！");
                        }

                        else if (k1 == 3)
                        {
                            WareHouse wareHouse = new WareHouse();
                            wareHouse.start();
                            wareHouse.join();
                            System.out.println("模拟结束");
                        }

                        else if (k1 == 4)
                        {
                            Leaders l1 = new Leaders("领导1") {
                                @Override
                                public void callback() {
                                    System.out.println("买小米的任务完成报告放在桌子上了。");
                                }
                            };
                            l1.setTask("买小米");
                            System.out.println("领导1的任务已发送");
                            Leaders l2 = new Leaders("领导2") {
                                @Override
                                public void callback() {
                                    System.out.println("苹果买回来已经砸了");
                                }
                            };
                            l2.setTask("买苹果");
                            System.out.println("领导2的任务已发送");
                            Leaders l3 = new Leaders("领导3") {
                                @Override
                                public void callback() {
                                    System.out.println("华为已经分给所有人了");
                                }
                            };
                            l3.setTask("买华为");
                            System.out.println("领导3的任务已发送");

                            //其实应该将所有子线程放在一个集合中再用循环调用所有子线程的join，但是根据我的例子就三个子线程，一个2秒，
                            //等七秒过后所有子线程其实也结束了
                            Thread.sleep(7000);

                        }

                        else if (k1 == 5)
                        {
                            StudentAdemin studentAdemin = new StudentAdemin();

                            studentAdemin.lodeFile("D:\\A_testc\\javaHomework_1\\jobSelection\\src\\function_system\\studentAdeminList\\StudentData.txt");

                            while (true) {
                                studentAdemin.showMenu();
                                System.out.println("请输入");
                                int cho = 0;
                                //保证输入为整数
                                while (true) {
                                    if (sc.hasNextInt()) {

                                        cho = sc.nextInt();
                                        if (cho >= 0 && cho <= 4)
                                            break;
                                    } else {
                                        System.out.println("请重新输入！");
                                        sc.next();
                                    }
                                }

                                if (cho == 1) {
                                    Student t = new Student();
                                    studentAdemin.addStudent(t);
                                } else if (cho == 2) {
                                    System.out.println("请输入要修改学生的编号");
                                    int case4_int = input_judge();
                                    studentAdemin.changeData(case4_int);
                                } else if (cho == 3) {
                                    System.out.println("请输入要删除学生的编号");
                                    int case4_int = input_judge();
                                    studentAdemin.removeStudent(case4_int);
                                } else if (cho == 4) {
                                    System.out.println("请输入姓名：");
                                    studentAdemin.findLike(sc.next());

                                } else if (cho == 0) {
                                    studentAdemin.savaFile("D:\\A_testc\\javaHomework_1\\jobSelection\\src\\function_system\\studentAdeminList\\StudentData.txt");
                                    break;
                                }
                            }

                        }
                        if (k1 == 0)
                            break;

                    }
                    break;
                }

                case 4:
                {

                    while (true)
                    {
                        menu.wor4_menu();
                        int choice = 0;
                        choice = input_judge();
                        if (choice == 1) {
                        CopyFile copyer = new CopyFile();
                        String file = "D:\\A_testc\\javaHomework_1\\jobSelection\\src\\function_system\\io\\resource1.txt";
                        String file2 = "D:\\A_testc\\javaHomework_1\\jobSelection\\src\\function_system\\io\\resource2.txt";
                        copyer.copy(file, file2);
                        }
                        else if (choice == 2)
                        {
                            CopyFile coper = new CopyFile();
                            String url = "https://img-blog.csdnimg.cn/img_convert/776acf3796503701aa326a1ef3a1ed19.webp?x-oss-process=image/format,png";
                            String fileName = "picture1";
                            String savaPath = "D:\\image1";
                            coper.copyPicture(url, fileName, savaPath);
                        }
                        else if(choice == 3)
                        {
                            MyWeather myWeather = new MyWeather();
                            myWeather.showWeather();
                        }
                        else if (choice == 0)
                        {
                            break;
                        }
                        else {
                            System.out.println("无此选项，请重新输入");
                        }
                    }
                }

                case 5:
                {
                    while (true)
                    {
                        menu.work5_menu();
                        int choice = input_judge();
                        if (choice == 1)
                        {
                            while (true)
                            {
                                StudentAdmain.showMenu();
                                int choice2 = input_judge();
                                if (choice2 == 1)
                                {
                                    StudentAdmain.addStudent();
                                }
                                else if (choice2 == 2)
                                {
                                    StudentAdmain.edit();
                                }
                                else if (choice2 == 3)
                                {
                                    StudentAdmain.delete();
                                }
                                else if (choice2 == 4)
                                {
                                    StudentAdmain.search();
                                }
                                else if (choice2 == 0)
                                {
                                    break;
                                }
                            }
                        }

                        else if (choice == 2)
                        {
                            while (true)
                            {
                                CourseOperation.shoeMenu();
                                int choice2 = input_judge();
                                if (choice2 == 1)
                                {
                                    CourseOperation.addCourse();
                                }
                                else if (choice2 == 2)
                                {
                                    CourseOperation.edit();
                                }
                                else if (choice2 == 3)
                                {
                                    CourseOperation.delete();
                                }
                                else if (choice2 == 4)
                                {
                                    CourseOperation.search();
                                }
                                else if (choice2 == 0)
                                {
                                    break;
                                }
                            }
                        }

                        else if (choice == 3)
                        {
                            while (true)
                            {
                                GradeOperation.gradeMenu();
                                int choice2 = input_judge();
                                if (choice2 == 1)
                                {
                                    GradeOperation.studentSelectCourse();
                                }
                                else if (choice2 == 2)
                                {
                                    GradeOperation.inputGrade();
                                }
                                else if (choice2 == 3)
                                {
                                    GradeOperation.queryGradeByStudent();
                                }
                                else if (choice2 == 0)
                                {
                                    break;
                                }
                            }
                        }
                        else if (choice == 0)
                        {
                            break;
                        }

                    }
                    break;
                }

                case 0:
                    break;
                default:
                    System.out.println("没有该选型，请重新选择。");
                    break;

            }
        }

    }
}
