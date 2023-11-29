package studentAdmainMysql;

import java.util.Scanner;

public class Course {
    static int count = 0;//数量
    private int no;//编号
    private String name;
    private double score;//学分



    public Course() throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.println("输入课程名称：");
        String name = sc.next();
        System.out.println("输入课程学分：");

        double score = 0;
        while(true)
        {
            if (sc.hasNextDouble())
            {
                score = sc.nextDouble();
                if (score >= 0)
                    break;
            }
            else {
                System.out.println("请输入大于0的数字！");
                sc.next();
            }
        }

        count=count+1;
        this.name = name;
        this.no = count;
        this.score = score;
    }

    public Course(int no,String name,double score) {
        this.no=no;
        this.name=name;
        this.score=score;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return this.no + "\t\t" + this.name + "\t\t" +this.score;
    }
}
