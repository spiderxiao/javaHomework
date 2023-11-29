package menu;

public class Menu
{
    public void main_menu()
    {
        System.out.println("请选择作业号：1——作业1； 0——退出");
        System.out.println("请选择作业号：2——作业2； 0——退出");
        System.out.println("请选择作业号：3——作业3； 0——退出");
        System.out.println("请选择作业号：4——作业4； 0——退出");
        System.out.println("请选择作业号：5——作业5； 0——退出");
    }

    public void work1_menu()
    {
        System.out.println("请选择题目序号：1——题目1；2——题目2；0——退出");
    }

    public void work2_menu()
    {
        System.out.println("----------------作业2----------------");
        System.out.println("1——累加器；2——实现手机信息的录入，并打印输出结果；");
        System.out.println("3——作业三；4——作业4");
        System.out.println("5——作业5(猜拳游戏)；6——作业6(日历)");
        System.out.println("7——作业7(学生成绩系统);0——退出");
        System.out.println("------------------------------------");
    }

    public void work3_menu()
    {
        System.out.println("----------------作业3----------------");
        System.out.println("1——客户选购信息管理系统；2——素数判断");
        System.out.println("3——仓库模拟卖货；4——回调");
        System.out.println("5——学生信息管理（集合）；0——退出");
        System.out.println("------------------------------------");
    }
    public void work_2_GradeAdemin_menu()
    {
        System.out.println("-----学生成绩管理系统--------");
        System.out.println("1---成绩录入");
        System.out.println("2---学生成绩打印");
        System.out.println("3---打印总成绩");
        System.out.println("0---退出");
    }

    public void wor4_menu()
    {
        System.out.println("----------------作业4----------------");
        System.out.println("1——文件拷贝");
        System.out.println("2——图片下载");
        System.out.println("3——天气查询");
    }


    public void work5_menu()
    {
        System.out.println("----------------作业5----------------");
        System.out.println("1——学生信息管理");
        System.out.println("2——课程信息管理");
        System.out.println("3——成绩管理");
        System.out.println("0——退出");
    }
}
