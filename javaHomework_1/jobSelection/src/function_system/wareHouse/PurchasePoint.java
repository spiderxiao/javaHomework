package function_system.wareHouse;


public class PurchasePoint extends Thread
{
    //当前商品数量
    private int num;
    private String goodsname;

    private static final Object object = new Object();

    @Override
    public void run() {
        synchronized (object)
        {
            if (num < 20) {
                num = num + 50;
                System.out.println(this.goodsname + "  库存已不足20，开始采购..." + '\n'
                        + "采购完成！" + this.goodsname + "当前存量为" + this.num);

            }
        }

    }

    public int get_num()
    {
        return this.num;
    }

    public void setGoodsname(String goodsname)
    {
        this.goodsname = goodsname;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public String getGoodsname()
    {
        return goodsname;
    }
}
