package technologies.trycatch;

import java.sql.*;

public class MysqlExample {
    /**
     * SQL 创建数据库 create database tech_test; // 注意不能使用中划线
     * SQL 创建表 create table user(id int auto_increment primary key, name varchar(200), age int);
     *          // 注意id既然已经声明了auto_increment了，就必须声明为主键，否则会报错
     * SQL插入数据 insert into user(name, age) values('Alice', 30), ('Bob', 25);
     *          // 因为不需要插入id， 所以需要写列名，因为不是插入所有列的值
     * @param args
     */
    public static void main(String []args) {
        // ！！！显式加载 MySQL 驱动，必须步骤否则报错 No suitable driver found for jdbc:mysql://yax-dt2-mysql01.exodushk.com/tech_test?useSSL=false&serverTimezone=UTC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return;
        }

        String url = "jdbc:mysql://yax-dt2-mysql01.exodushk.com/tech_test?useSSL=false&serverTimezone=UTC";
        String username = "admin";
        String password = "Exodus123";

        String sql = "SELECT id, name, age FROM user where id = ?";

         try (
                 Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement ps = conn.prepareStatement(sql);
         ) {
             ps.setInt(1, 1);
             // try-with-resources 语法会自动关闭 ResultSet，PreparedStatement 和 Connection 但依然需要手动catch异常
             try (ResultSet rs = ps.executeQuery()) {
                 while (rs.next()) {
                     int id = rs.getInt("id");
                     String name = rs.getString("name");
                     int age = rs.getInt("age");
                     System.out.println("user id: " + id + ", name: " + name + ", age: " + age);
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }
}

