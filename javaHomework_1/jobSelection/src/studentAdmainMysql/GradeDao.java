package studentAdmainMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao
{


    public static List<Course> findCoursesSelectBystudent(Student s, boolean f) {

        List<Course> selectCourses = new ArrayList<>();
        Connection conn = DatabaseLink.getConn();
        int stuNo = s.getNo();
        String sql = "";

        //已选
        if (f) {
            sql = "select * from course where no in (select g.courseNo from grade g where stuNo=?)";

        }
        //未选课程
        else {

            sql = "select * from course where no not in (select g.courseNo from grade g where stuNo=?)";

        }

        try {

            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, stuNo);

            ResultSet result = p.executeQuery();
            selectCourses = CourseDao.coursesResults(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return selectCourses;

    }


//查询某一学生的一项成绩
    public static Grade getOneByStuAndCourse(Student s, Course c) {

        String sql = " and (g.stuNo="+s.getNo()+" and g.courseNo="+c.getNo() +")";

        List<Grade> grades=new ArrayList<Grade>();

        grades = search(sql);

        if(grades.isEmpty()) {

            return null;

        }

        return grades.get(0);

    }


//插入
    public static void insert(Grade g) {

        Connection conn = DatabaseLink.getConn();

        String sql = "insert into grade (stuNo,courseNo) values (?,?)";

        try {

            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, g.getStudent().getNo());
            p.setInt(2, g.getCourse().getNo());
            p.executeUpdate();
            p.close();
            conn.close();
        } catch (SQLException e) {

            e.printStackTrace();

            System.out.println("数据插入失败！！");

        }

    }




//修改成绩
    public static int updateGrade(double grade, int no) {

        int i = 0;
        Connection conn = DatabaseLink.getConn();
        String sql = "update grade set grade=? where no=?";

        try {

            PreparedStatement p = conn.prepareStatement(sql);

            p.setDouble(1, grade);

            p.setInt(2, no);

            i = p.executeUpdate();



            p.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return i;

    }





    // 返回grade对象的集合的基本查询,在输入不同的sql条件实现组合查询

    public static List<Grade> search(String sql1) {

        List<Grade> results = new ArrayList<Grade>();
        Connection conn = DatabaseLink.getConn();
        String sql = "select g.no, s.no as stuNo, s.name as stuName, s.major, "

                + "c.no as courseNo,c.name as courseName,c.score, "

                + "g.grade "

                + "from student s, course c, grade g "

                + "where s.no=g.stuNo and c.no=g.courseNo ";

        sql = sql + sql1;

        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {

                int no = resultSet.getInt("no");
                int stuNo = resultSet.getInt("stuNo");
                String stuName = resultSet.getString("stuName");
                String major = resultSet.getString("major");
                int courseNo = resultSet.getInt("courseNo");
                String courseName = resultSet.getString("courseName");

                int mark = resultSet.getInt(7);
                double score = resultSet.getDouble(8);
                Student student = new Student(stuNo, stuName, major);
                Course course = new Course(courseNo, courseName, mark);
                Grade grade = new Grade();
                grade.setCourse(course);

                grade.setNo(no);

                grade.setStudent(student);
                grade.setGrade(score);
                results.add(grade);

            }

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        return results;

    }


//查询课程
    public static List<Grade> findGradesByCourse(Course c){

        List<Grade> grades=new ArrayList<Grade>();

        String sql= "and c.no="+c.getNo();

        grades = search(sql);

        return grades;

    }



    public static List<Grade> findGradesByStudent(Student s){

        List<Grade> grades=new ArrayList<Grade>();

        String sql= "and s.no="+s.getNo();

        grades=search(sql);

        return grades;

    }
}
