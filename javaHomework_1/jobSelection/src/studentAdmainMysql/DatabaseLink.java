package studentAdmainMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLink {


    public static Connection getConn() {

        String driverName = "org.gjt.mm.mysql.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Chongqing";
        String userName = "root";
        String password = "632207060318xhy";
        try
        {
            Class.forName(driverName);
            Connection conn;
            conn = (Connection) DriverManager.getConnection(dbUrl, userName, password);
            return conn;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("数据库连接失败！");
        }
        return null;

    }


    public static void executeSql(Connection c,String sql) {

        try {
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();//操作
            p.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("数据库操作异常！");

        }

    }





}