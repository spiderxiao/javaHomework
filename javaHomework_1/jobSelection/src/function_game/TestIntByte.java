package function_game;

public class TestIntByte
{
    public int max_int = Integer.MAX_VALUE;
    public int min_int = Integer.MIN_VALUE;
    public byte max_byte = Byte.MAX_VALUE;
    public byte min_byte = Byte.MIN_VALUE;



    public void show_byte()
    {
        double x = (double)(max_byte - min_byte + 1);
        String s = "127";
        byte s_byte = Byte.parseByte(s);

        System.out.println("byte的数据总数：" + x);
        System.out.println("byte的取值范围：" + min_byte + "~" + max_byte);
        System.out.println("将字符串" + s + "转换为byte类型：" + s_byte);
        System.out.println();
    }
    public void show_int()
    {
        long t1 = max_int;
        long t2 = min_int;
        double x = (double)(t1 - t2 + 1);

        String s = "50000";
        int s_int = Integer.parseInt(s);
        int y = 16;
        String y_binary = Integer.toBinaryString(y);
        String y_hexadecimal = Integer.toHexString(y);

        String range_int = String.format("%.9e", x);
        System.out.println("int的数据总数：" + x);
        System.out.println("int的取值范围：" + min_int + "~" + max_int);
        System.out.println("将字符串" + s + "转换为int类型：" + s_int);
        System.out.println(y + "转化为2进制：" + y_binary);
        System.out.println(y + "转化为16进制数：" + y_hexadecimal);
        System.out.println();

    }
}
