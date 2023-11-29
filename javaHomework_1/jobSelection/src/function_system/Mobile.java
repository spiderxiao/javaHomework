package function_system;

import java.util.Scanner;

public class Mobile
{
    public String phoneBrand;
    public String controlSystem;
    public int cpuNuber;
    public double price;

    public Mobile(String phoneBrand, String controlSystem, int cpuNuber, double price)
    {
        this.phoneBrand = phoneBrand;
        this.controlSystem = controlSystem;
        this.cpuNuber = cpuNuber;
        this.price = price;
    }

    public Mobile()
    {
        this.phoneBrand = "NULL";
        this.controlSystem = "NULL";
        this.cpuNuber = 0;
        this.price = 0;
    }

    public void setMobile()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入");
        System.out.print("手机品牌：");
        this.phoneBrand = sc.next();
        System.out.print("操作系统：");
        this.controlSystem = sc.next();
        System.out.print("CPU数：");
        //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.cpuNuber = sc.nextInt();
                break;
            }
            else {
                System.out.println("CPU数量只能为整数，请重新输入！");
                sc.next();
            }
        }
        System.out.print("价格：");
        //保证输入为整数
        while(true)
        {
            if (sc.hasNextDouble())
            {
                this.price = sc.nextInt();
                break;
            }
            else {
                System.out.println("价格只能输入数字，请重新输入！");
                sc.next();
            }
        }

    }

    public void output()
    {
        System.out.printf("手机品牌：%s\n", this.phoneBrand);
        System.out.printf("操作系统:%s\n", this.controlSystem);
        System.out.printf("CPU数：%d\n", this.cpuNuber);
        System.out.printf("价格：%.1f\n", this.price);
    }


}
