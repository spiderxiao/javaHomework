package studentAdmainMysql;

public class Grade
{
    private int no;
    private Student student;//学生
    private Course course;//课程
    private double grade;//成绩
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {

        this.student = student;

    }

    public int getNo(){

        return no;
    }

    public void setNo(int no)
    {
        this.no = no;
    }

    public Course getCourse() {

        return course;

    }

    public void setCourse(Course course) {

        this.course = course;

    }

    public double getGrade() {

        return grade;

    }

    public void setGrade(double grade) {

        this.grade = grade;

    }
}
