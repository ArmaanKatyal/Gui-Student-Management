import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


class App_interface{
    JFrame Main_Frame = new JFrame();
    App_interface() {
        JButton b1 = new JButton("Add Student");
        JButton b2 = new JButton("Search Student");
        JButton b3 = new JButton("Update Details");
        JButton b4 = new JButton("Delete Student");
        JButton exit_main = new JButton("Exit");
        Main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main_Frame.add(b1);
        Main_Frame.add(b2);
        Main_Frame.add(b3);
        Main_Frame.add(b4);
        Main_Frame.add(exit_main);
        Main_Frame.setTitle("Student Management");
        Main_Frame.setSize(200,270);
        Main_Frame.setLayout(null);
        Main_Frame.setVisible(true);

        // Set Bounds
        b1.setBounds(70,20,150,30);
        b2.setBounds(70,60,150,30);
        b3.setBounds(70,100,150,30);
        b4.setBounds(70,140,150,30);
        exit_main.setBounds(70,180,150,30);

        // Buttons Actions
        exit_main.addActionListener(e -> System.exit(1));
        b1.addActionListener(e -> First_Inner_Frame());
        b2.addActionListener(e -> Second_Inner_Frame());
        b3.addActionListener(e -> Third_Inner_Frame());
        b4.addActionListener(e -> Fourth_Inner_Frame());
    }

    public void First_Inner_Frame(){
        JFrame addStudent_frame = new JFrame();
        addStudent_frame.setDefaultCloseOperation(addStudent_frame.HIDE_ON_CLOSE);
        // Label Section
        JLabel l1 = new JLabel("ID: ");
        l1.setBounds(10,20,50,30);
        JLabel l2 = new JLabel("Name: ");
        l2.setBounds(10,60,50,30);
        JLabel l3 = new JLabel("Age: ");
        l3.setBounds(10,100,50,30);
        JLabel l4 = new JLabel("Course: ");
        l4.setBounds(10,140,50,30);
        JLabel l5 = new JLabel("Result: ");
        l5.setBounds(10,220,50,30);
        JLabel l6 = new JLabel("");
        l6.setBounds(70,220,150,30);

        // Button Section
        JButton b1 = new JButton("Submit");
        b1.setBounds(10,180,100,30);
        JButton b2 = new JButton("Exit");
        b2.setBounds(120,180,100,30);


        // TextField Section
        JTextField f1 = new JTextField();
        f1.setBounds(70,20,130,30);
        JTextField f2 = new JTextField();
        f2.setBounds(70,60,130,30);
        JTextField f3 = new JTextField();
        f3.setBounds(70,100,130,30);
        JTextField f4 = new JTextField();
        f4.setBounds(70,140,130,30);

        // Button on click
        b2.addActionListener(e -> addStudent_frame.dispose());
        b1.addActionListener(e -> {
            SqlDatabase sq = new SqlDatabase();
            sq.Insert_data(Integer.parseInt(f1.getText()),f2.getText(),Integer.parseInt(f3.getText()),f4.getText());
            f1.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
            l6.setText("Submitted Successfully");
        });

        // Integration with Frame
        addStudent_frame.add(b1);
        addStudent_frame.add(b2);
        addStudent_frame.add(l1);
        addStudent_frame.add(l2);
        addStudent_frame.add(l3);
        addStudent_frame.add(l4);
        addStudent_frame.add(f1);
        addStudent_frame.add(f2);
        addStudent_frame.add(f3);
        addStudent_frame.add(f4);
        addStudent_frame.add(l5);
        addStudent_frame.add(l6);
        addStudent_frame.setSize(250,300);
        addStudent_frame.setLayout(null);
        addStudent_frame.setVisible(true);
        addStudent_frame.setTitle("Add Student");
        addStudent_frame.setLocation(350, Toolkit.getDefaultToolkit().getScreenSize().height-865);
    }

    public void Second_Inner_Frame(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javadb";
            String uname = "root";
            String password = "armaan2408";
            String sql = "select * from students_new";
            Connection conn = DriverManager.getConnection(url, uname, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            // Frame Integration
            JFrame search_student = new JFrame();
            //Table
            JTable t1 = new JTable();
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            t1.setSize(search_student.getSize());

            // Scrolling
            JScrollPane sp = new JScrollPane(t1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            sp.setSize(search_student.getSize());

            // Integration with Frame
            search_student.add(sp);
            search_student.setVisible(true);
            search_student.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            search_student.setLayout(null);
            search_student.setTitle("Student Database");
            search_student.setLocation(350, Toolkit.getDefaultToolkit().getScreenSize().height-865);
            search_student.setSize(500,300);
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void Third_Inner_Frame(){
        // Frame Integration
        JFrame update_student = new JFrame();
        update_student.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        update_student.setVisible(true);
        update_student.setLayout(null);
        update_student.setTitle("Update Student Details");
        update_student.setSize(250,300);

        // Buttons
        JButton b1 = new JButton("Update Name");
        JButton b2 = new JButton("Update Age");
        JButton b3 = new JButton("Update Course");
        JButton exit = new JButton("Exit");
        // Set Bounds
        b1.setBounds(70,20,150,30);
        b2.setBounds(70,60,150,30);
        b3.setBounds(70,100,150,30);
        exit.setBounds(70,180,150,30);

        // Button On Click
        exit.addActionListener(e -> update_student.dispose());
        b1.addActionListener(e -> Third_Inner_frame_name());
        b2.addActionListener(e -> Third_Inner_frame_age());
        b3.addActionListener(e -> Third_Inner_frame_course());

        // Integration with Frame
        update_student.add(exit);
        update_student.add(b1);
        update_student.add(b2);
        update_student.add(b3);
    }

    public void Third_Inner_frame_name(){
        // Frame Integration
        JFrame update_student_name = new JFrame();
        update_student_name.setVisible(true);
        update_student_name.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        update_student_name.setLocation(350, Toolkit.getDefaultToolkit().getScreenSize().height-865);
        update_student_name.setLayout(null);
        update_student_name.setTitle("Update Student Name");
        update_student_name.setSize(250,200);

        // Labels
        JLabel l1 = new JLabel("ID: ");
        JLabel l2 = new JLabel("Name: ");
        JLabel l3 = new JLabel("Result: ");
        JLabel l4 = new JLabel("");

        // Buttons
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Exit");

        // TextFields
        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();

        // Set Bounds
        l1.setBounds(10,20,50,30);
        f1.setBounds(70,20,150,30);
        l2.setBounds(10,60,50,30);
        f2.setBounds(70,60,150,30);
        b1.setBounds(10,100,100,30);
        b2.setBounds(120,100,100,30);
        l3.setBounds(10,140,50,30);
        l4.setBounds(70,140,150,30);

        //Buttons On Click
        b2.addActionListener(e -> update_student_name.dispose());
        b1.addActionListener(e -> {
            SqlDatabase.Update_Students up = new SqlDatabase.Update_Students();
            up.Update_Student_name(Integer.parseInt(f1.getText()),f2.getText());
            f1.setText("");
            f2.setText("");
            l4.setText("Name Updated");
        });

        // Integration with Frame
        update_student_name.add(l1);
        update_student_name.add(l2);
        update_student_name.add(l3);
        update_student_name.add(l4);
        update_student_name.add(b1);
        update_student_name.add(b2);
        update_student_name.add(f1);
        update_student_name.add(f2);
    }

    public void Third_Inner_frame_age(){
        // Frame Integration
        JFrame update_student_age = new JFrame();
        update_student_age.setVisible(true);
        update_student_age.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        update_student_age.setLocation(350, Toolkit.getDefaultToolkit().getScreenSize().height-865);
        update_student_age.setLayout(null);
        update_student_age.setTitle("Update Student Age");
        update_student_age.setSize(250,200);

        // Labels
        JLabel l1 = new JLabel("ID: ");
        JLabel l2 = new JLabel("Age: ");
        JLabel l3 = new JLabel("Result: ");
        JLabel l4 = new JLabel("");

        // Buttons
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Exit");

        // TextFields
        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();

        // Set Bounds
        l1.setBounds(10,20,50,30);
        f1.setBounds(70,20,150,30);
        l2.setBounds(10,60,50,30);
        f2.setBounds(70,60,150,30);
        b1.setBounds(10,100,100,30);
        b2.setBounds(120,100,100,30);
        l3.setBounds(10,140,50,30);
        l4.setBounds(70,140,150,30);

        // Buttons On Click
        b2.addActionListener(e -> update_student_age.dispose());
        b1.addActionListener(e -> {
            SqlDatabase.Update_Students up = new SqlDatabase.Update_Students();
            up.Update_Student_age(Integer.parseInt(f1.getText()),Integer.parseInt(f2.getText()));
            f1.setText("");
            f2.setText("");
            l4.setText("Age Updated");
        });

        // Integration with Frame
        update_student_age.add(l1);
        update_student_age.add(l2);
        update_student_age.add(l3);
        update_student_age.add(l4);
        update_student_age.add(b1);
        update_student_age.add(b2);
        update_student_age.add(f1);
        update_student_age.add(f2);
    }

    public void Third_Inner_frame_course(){
        // Frame Integration
        JFrame update_student_course = new JFrame();
        update_student_course.setVisible(true);
        update_student_course.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        update_student_course.setLocation(350, Toolkit.getDefaultToolkit().getScreenSize().height-865);
        update_student_course.setLayout(null);
        update_student_course.setTitle("Update Student Course");
        update_student_course.setSize(250,200);

        // Labels
        JLabel l1 = new JLabel("ID: ");
        JLabel l2 = new JLabel("Course: ");
        JLabel l3 = new JLabel("Result: ");
        JLabel l4 = new JLabel("");

        // Buttons
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Exit");

        // TextFields
        JTextField f1 = new JTextField();
        JTextField f2 = new JTextField();

        // Set Bounds
        l1.setBounds(10,20,50,30);
        f1.setBounds(70,20,150,30);
        l2.setBounds(10,60,50,30);
        f2.setBounds(70,60,150,30);
        b1.setBounds(10,100,100,30);
        b2.setBounds(120,100,100,30);
        l3.setBounds(10,140,50,30);
        l4.setBounds(70,140,150,30);

        //Buttons On Click
        b2.addActionListener(e -> update_student_course.dispose());
        b1.addActionListener(e -> {
            SqlDatabase.Update_Students up = new SqlDatabase.Update_Students();
            up.Update_Student_course(Integer.parseInt(f1.getText()),f2.getText());
            f1.setText("");
            f2.setText("");
            l4.setText("Course Updated");
        });

        // Integration with Frame
        update_student_course.add(l1);
        update_student_course.add(l2);
        update_student_course.add(l3);
        update_student_course.add(l4);
        update_student_course.add(b1);
        update_student_course.add(b2);
        update_student_course.add(f1);
        update_student_course.add(f2);
    }

    public void Fourth_Inner_Frame(){
        // Frame Integration
        JFrame delete_student = new JFrame();
        delete_student.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        delete_student.setVisible(true);
        delete_student.setLayout(null);
        delete_student.setTitle("Delete Student");
        delete_student.setLocation(350,Toolkit.getDefaultToolkit().getScreenSize().height-550);
        delete_student.setSize(250,200);

        // Labels
        JLabel l1 = new JLabel("ID: ");
        l1.setBounds(10,20,50,30);
        JLabel l2 = new JLabel("Result: ");
        l2.setBounds(10,110,50,30);
        JLabel l3 = new JLabel("");
        l3.setBounds(70,110,150,30);

        // TextField
        JTextField f1 = new JTextField();
        f1.setBounds(70,20,150,30);

        // Buttons
        JButton b1 = new JButton("Submit");
        b1.setBounds(10,70,100,30);
        JButton b2 = new JButton("Exit");
        b2.setBounds(120,70,100,30);

        // Buttons On Click
        b2.addActionListener(e -> delete_student.dispose());
        b1.addActionListener(e -> {
            SqlDatabase sq = new SqlDatabase();
            sq.Delete_Data(Integer.parseInt(f1.getText()));
            f1.setText("");
            l3.setText("Deleted Successfully");
        });

        // Frame Integration
        delete_student.add(b2);
        delete_student.add(b1);
        delete_student.add(l1);
        delete_student.add(f1);
        delete_student.add(l2);
        delete_student.add(l3);
    }
}
public class NewGui {
    public static void main(String[] args) {
        new App_interface();
    }
}
