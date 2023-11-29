package function_system.wareHouse;

public class WareHouse extends Thread
{
    public static final int min_num = 20;
    public static final int max_num = 50;
    private SalePoint[] salePoints;
    private int sale_num;
    private static PurchasePoint[] purchasePoints;
    private int purchase_num;

    public WareHouse()
    {
        purchasePoints = new PurchasePoint[3];

        purchasePoints[0] = new PurchasePoint();
        purchasePoints[1] = new PurchasePoint();
        purchasePoints[2] = new PurchasePoint();

        purchasePoints[0].setGoodsname("苹果");
        purchasePoints[0].setNum(20);
        purchasePoints[1].setGoodsname("香蕉");
        purchasePoints[1].setNum(20);
        purchasePoints[2].setGoodsname("芒果");
        purchasePoints[2].setNum(20);

        salePoints = new SalePoint[3];

        salePoints[0] = new SalePoint();
        salePoints[1] = new SalePoint();
        salePoints[2] = new SalePoint();

        salePoints[0].setName("销售点一");
        salePoints[1].setName("销售点二");
        salePoints[2].setName("销售点三");

        this.sale_num = 3;
        this.purchase_num = 3;
    }

    @Override
    public void run()
    {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < 10000) {
            Thread a = new Thread(salePoints[0]);
            a.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread b = new Thread(salePoints[1]);
            b.start();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            Thread c = new Thread(salePoints[2]);
            c.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ;
//        while (System.currentTimeMillis() - startTime < 2000) {
//
//
//            if (System.currentTimeMillis() - startTime > 10000)
//                System.out.println("十秒到了！！！");
//        }

//        System.out.println("a,b,c全部调用");




    }

    public static PurchasePoint get_purchasePoint(int i)
    {
        return purchasePoints[i];
    }

    public int getPurchase_num()
    {
        return this.purchase_num;
    }

}
