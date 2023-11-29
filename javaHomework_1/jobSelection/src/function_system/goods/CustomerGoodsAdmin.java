package function_system.goods;

import java.util.Arrays;
import java.util.Scanner;

public class CustomerGoodsAdmin
{
    private static Customer[] customers;//顾客数组

    private int num;//顾客数量



    private static Goods[] totalGoods;//所有商品
    private static int goods_num;//商品数量
    //用户交互界面
    public void show()
    {
        System.out.println("1、添加货物");
        System.out.println("2、展示所有顾客信息");
        System.out.println("3、展示所有商品信息");
        System.out.println("0、退出");
    }


    //客户采购信息输入
    public Customer inputCustomerInfo()
    {

        if (this.num == 0)
            customers = new Customer[1];
        else
            customers = Arrays.copyOf(customers, this.num + 1);
        customers[num] = new Customer();
        this.num++;
        return customers[num - 1];
    }



    //展示所有顾客信息
    public void show_all_customer()
    {
        if (this.num == 0)
        {
            System.out.println("当前暂无顾客信息！");
            return;
        }
        for (int i = 0; i < this.num; i++)
        {
            customers[i].print();
        }
    }

    //展示所有商品
    public void show_all_goods()
    {
        if (this.goods_num == 0)
        {
            System.out.println("当前暂无商品！");
            return;
        }
        for (int i = 0; i < this.goods_num; i++)
        {
            System.out.print("【" + i + "】");
            System.out.println(totalGoods[i] + "数量：" + this.totalGoods[i].getNum());
        }
    }


    //进货
    public void inputGoods()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入进货的商品种类数量：");

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

        //扩容
        if (this.goods_num == 0)
            this.totalGoods = new Goods[n];
        else
            this.totalGoods = Arrays.copyOf(this.totalGoods, n + this.goods_num);


        for (int i = goods_num; i < n + goods_num; i++)
        {
            Goods t = new Goods();
            totalGoods[i] = t;
        }
        this.goods_num += n;

    }


    //获取当前商品
    public static Goods getGoods(int i)
    {

        return totalGoods[i];
    }


    //获取当前商品单价
    public static double getPrice(int i)
    {
        return totalGoods[i].getPrice();
    }

    //获取商品数量

    public static int getGoods_num() {
        return goods_num;
    }

    //修改某一商品的数量
    public static void setTotalGoods(int a, int b)
    {
        int t = CustomerGoodsAdmin.totalGoods[a].getNum();
        CustomerGoodsAdmin.totalGoods[a].setNum(t - b);
    }
}
