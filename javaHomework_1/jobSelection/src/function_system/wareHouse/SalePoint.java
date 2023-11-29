package function_system.wareHouse;


public class SalePoint extends Thread
{
    //该销售点的商品数组（进货点只能买一种商品，所以进货点可以看做商品）
    //销售点的商品就是库存的商品

    private final static Object object = new Object();


    @Override
    public void run()
    {
        synchronized (object)
        {
            try {

                double t = Math.random();
                int t1 = (int) (Math.random() * 20) + 1;

                if (t < 0.33) {
                    sale(0, t1);
                } else if (t > 0.33 && t < 0.66) {
                    sale(1, t1);
                } else {
                    sale(2, t1);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sale(int n, int t1) throws InterruptedException {

        //补货的线程需要新开一个，不然会造成一个线程多次start的bug
        Thread purchasePoint = new Thread(WareHouse.get_purchasePoint(n));

        int total = WareHouse.get_purchasePoint(n).get_num();
        if (total < 20)
        {

            return;
        }



        System.out.println(this.getName() +  "卖出" + t1 + "个" + WareHouse.get_purchasePoint(n).getGoodsname());


        WareHouse.get_purchasePoint(n).setNum(total - t1);

        purchasePoint.start();



    }

}
