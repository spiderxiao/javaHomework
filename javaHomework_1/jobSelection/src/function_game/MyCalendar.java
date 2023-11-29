package function_game;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MyCalendar
{
    public int year;
    public int mon;

    public MyCalendar(int year, int mon)
    {
        this.year = year;
        this.mon = mon;
    }
    public MyCalendar()
    {
        this.year = 0;
        this.mon = 0;
    }
    public void set_date()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("输入年份: ");
        this.year = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.year = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }

        System.out.println("输入月份:1--12 ");
        this.mon = 0;
        while(true)
        {
            if (sc.hasNextInt())
            {
                this.mon = sc.nextInt();
                break;
            }
            else {
                System.out.println("请输入数字！");
                sc.next();
            }
        }
    }

    public void show()
    {
        LocalDate inputDate = LocalDate.of(year, mon, 1);
        LocalDate targetDate = LocalDate.of(2023, 9, 1);
        long daysBetween = 0;
        long x = 0;
        if (year <= 2023)
        {
            daysBetween = ChronoUnit.DAYS.between(inputDate, targetDate);
            x = daysBetween % 7;
            if (x < 5)
            {
                x = 5 - x - 1;

                //2023 11
                x %= 7;
            }
            else
            {
                if(x == 6)
                    x = 5;
                else
                    x = 6;
            }
        }
        if (year > 2023) {
            daysBetween = ChronoUnit.DAYS.between(targetDate, inputDate);
            x = (daysBetween + 4) % 7;

        }
        int day_number = 0;
        //每月天数计算
        if (mon != 2) {
            if (mon == 1 || mon == 3 || mon == 5 || mon == 7 ||
                    mon == 8 || mon == 10 || mon == 12)
                day_number = 31;
            else
                day_number = 30;
        } else {
            if (year % 4 == 0 && year % 100 != 0)
                day_number = 29;
            else
                day_number = 28;
        }
        System.out.print("----------------");
        System.out.print(year);
        System.out.print("年");
        System.out.print(mon + "月");
        System.out.println("----------------");

        System.out.printf("%3c", '一');
        System.out.printf("%4c", '二');
        System.out.printf("%3c", '三');
        System.out.printf("%4c", '四');
        System.out.printf("%3c", '五');
        System.out.printf("%4c", '六');
        System.out.printf("%3c\n", '日');


        if (year <= 2023) {
            for (int i = 0; i < x; i++)
                System.out.print("    ");
        }
        if (year > 2023) {
            for (int i = 0; i < x; i++)
                System.out.print("    ");
        }


        for (int i = 1; i <= day_number; i++) {
            x++;
            if (x % 7 == 0) {
                System.out.printf("%4d\n", i);

            } else {
                System.out.printf("%4d", i);
            }
        }
        System.out.println();
        System.out.println("----------------------------------------");


    }

}
