package function_system.goods;

import javax.swing.plaf.InsetsUIResource;
import java.util.Scanner;

public class Goods
{
    private String name;//姓名
    private int num;//数量
    private double price;//单价
    private double totalPrice;//总价

    Goods()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("名称："); name = sc.next();
        System.out.println("数量：");

        while(true)
        {
            if (sc.hasNextInt())
            {
                num = sc.nextInt();
                if (num >= 0)
                break;
            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }
        System.out.println("单价：");

        while(true)
        {
            if (sc.hasNextDouble())
            {
                price = sc.nextDouble();
                if (price >= 0)
                break;
            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }

        System.out.printf("总价：%.2f\n", num * price);
        this.totalPrice = num * price;
    }


    public double getPrice()
    {
        return price;
    }
    public String getName()
    {
        return name;
    }
    public double getTotalPrice()
    {
        return totalPrice;
    }
    public int getNum()
    {
        return num;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNum(int num)
    {

        this.num = num;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString()
    {
        System.out.print(name + "     ;单价：" + price + "      ;");

        return "";
    }

}
