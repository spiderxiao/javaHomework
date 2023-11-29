package function_system.goods;

import java.util.Arrays;
import java.util.Scanner;

public class Customer
{
    private String name;//姓名
    private int age;//年龄
    private Goods[] goods;//商品
    private double total;//总采购金额

    private  int num;
    private int num_goods[];//购买物品的数量
    public Customer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        name = sc.next();

        System.out.println("请输入年龄：");
        //保证输入为整数
        while(true)
        {
            if (sc.hasNextInt())
            {
                age = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入整数！");
                sc.next();
            }
        }


        goods = new Goods[10];
        total = 0;
        num = 0;
        num_goods = new int[10];
    }
    public Customer(String name, int age, Goods[] goods, double total)
    {
        this.name = name;
        this.age = age;
        this.goods = goods;
        this.total = total;
    }

    //打印发票
    public void print()
    {
        System.out.println("姓名" + name + "      ;年龄" + age);
        System.out.println("------------------------------");

        for (int i = 0; i < this.num; i++)
        {
            System.out.print(goods[i] + "购买数量：" + num_goods[i] + "    ;总计：");
            System.out.printf("%.2f\n",num_goods[i] * goods[i].getPrice());
        }

        System.out.printf("总采购金额%.2f\n", total);
    }

    //买
    public void buy()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请依次输入商品序号和购买数量");
        int a = 0;
        int b = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                a = sc.nextInt();

                if (a >= 0 && a < CustomerGoodsAdmin.getGoods_num())
                {
                    break;
                }
                else
                    System.out.println("编号输入错误");
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }
        while(true)
        {
            if (sc.hasNextInt())
            {
                b = sc.nextInt();
                if (b >= 0 && b <= CustomerGoodsAdmin.getGoods(a).getNum())
                break;
                else
                    System.out.println("购买数量输入错误");
            }
            else {
                System.out.println("无此选项，请重新输入！");
                sc.next();
            }
        }

        goods[num] = CustomerGoodsAdmin.getGoods(a);
        num_goods[num] += b;
        this.total = this.total + b * CustomerGoodsAdmin.getPrice(a);

        //买了东西总数量要减少
        CustomerGoodsAdmin.setTotalGoods(a, b);

        this.num++;
        //扩容
        if (this.num % 10 == 0)
        {
            goods = Arrays.copyOf(goods, this.num + 10);
            num_goods = Arrays.copyOf(num_goods, this.num + 10);
        }
    }


    //功能菜单
    public void show()
    {
        System.out.println("1、购物");
        System.out.println("2、结账");
    }
}
