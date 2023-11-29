package studentAdmainMysql;


import com.sun.tools.attach.AgentInitializationException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataBaseOperation
{
    public Connection getConn()
    {
        String url = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Chongqing";
        String userName = "root";
        String password = "632207060318xhy";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, password);
            if (conn != null)
            {
                System.out.println("数据库连接成功");
                return conn;
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    //插入
    public int insert(Student s)
    {
        Connection conn = getConn();
        String sql = "insert into student (name,major) value(?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getMajor());
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.close();
            conn.close();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return -1;

    }

    //删除
    public int delete(int no)
    {
        Connection conn = getConn();
        String sql = "delete from student where no=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, no);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.close();
            conn.close();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //更新
    public int update(Student s)
    {
        Connection conn = getConn();
        String sql = "update student set name=? where no=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, s.getName());
            preparedStatement.setString(2, s.getMajor());
            preparedStatement.setInt(3, s.getNo());
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            preparedStatement.close();
            conn.close();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //查询
    public List<Student> find(String key)
    {
        Connection conn = getConn();
        List<Student> students = new ArrayList<>();
        String sql = "select * from student where name like ? or major like ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            ResultSet sets = preparedStatement.executeQuery();
            while (sets.next())
            {
                int no = sets.getInt("no");
                String name = sets.getString("name");
                String magor = sets.getString("major");
                Student s = new Student(no, name, magor);
                students.add(s);

            }
            preparedStatement.close();
            conn.close();
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
