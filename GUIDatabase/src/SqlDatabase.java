import java.sql.*;

public class SqlDatabase {

    void Insert_data(int id, String name, int age, String course){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javadb";
            String uname = "root";
            String password = "yourPass";
            Connection conn = DriverManager.getConnection(url, uname, password);
            Statement stmt = conn.createStatement();
            String sql = String.format("insert into students_new values(%d,\"%s\",%d,\"%s\")",id,name,age,course);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    void Delete_Data(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javadb";
            String uname = "root";
            String password = "your pass";
            Connection conn = DriverManager.getConnection(url, uname, password);
            Statement stmt = conn.createStatement();
            String sql = String.format("delete from students_new where id=%d",id);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class Update_Students {
        void Update_Student_name(int id, String name) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/javadb";
                String uname = "root";
                String password = "your pass";
                Connection conn = DriverManager.getConnection(url, uname, password);
                Statement stmt = conn.createStatement();
                String sql = String.format("update students_new set name=\"%s\" where id=%d",name,id);
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        void Update_Student_age(int id, int age) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/javadb";
                String uname = "root";
                String password = "your pass";
                Connection conn = DriverManager.getConnection(url, uname, password);
                Statement stmt = conn.createStatement();
                String sql = String.format("update students_new set age=%d where id=%d",age,id);
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        void Update_Student_course(int id, String course) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/javadb";
                String uname = "root";
                String password = "your pass";
                Connection conn = DriverManager.getConnection(url, uname, password);
                Statement stmt = conn.createStatement();
                String sql = String.format("update students_new set course=\"%s\" where id=%d",course,id);
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

    }

}
