package UMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Lecturer {
    public void SignIn() {
        JFrame lecturer = new JFrame("University Management System");
        lecturer.setSize(500, 500);

        JLabel Username = new JLabel("Username");
        Username.setBounds(100, 100, 80, 30);
        JTextField txtUsername = new JTextField(20);
        txtUsername.setBounds(100, 150, 150, 30);
        JLabel Password = new JLabel("Password");
        Password.setBounds(100, 200, 90, 30);
        JPasswordField txtPassword = new JPasswordField(20);
        txtPassword.setBounds(100, 250, 150, 30);
        JButton Signin = new JButton("Sign In");
        Signin.setBounds(100, 300, 80, 30);

        lecturer.add(Username);
        lecturer.add(txtUsername);
        lecturer.add(Password);
        lecturer.add(txtPassword);
        lecturer.add(Signin);

        lecturer.setLayout(null);
        lecturer.setVisible(true);

        Connection con = null;
        Signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lecturer.dispose();
                try {
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/u_m_s?serverTimezone=UTC", "root", "");
                    Statement stmt = con.createStatement();
                    String sql = "select * from lecturer where Uname = ? and Password = ?";

                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, txtUsername.getText());
                    pst.setString(2, String.valueOf(txtPassword.getPassword()));
                    ResultSet rs = pst.executeQuery();

                    if(rs.next())
                        JOptionPane.showMessageDialog(null,"Username and Password matched");
                    else
                        JOptionPane.showMessageDialog(null, "Username and Password not matched");

                        JFrame lec_details = new JFrame("University Management System");
                        lec_details.setSize(500, 300);
                        //JPanel p1 = new JPanel();
                        //p1.setSize(500,500);
                        //JPanel p2 = new JPanel();
                        //p2.setSize(500,500);
                        //JTabbedPane tp = new JTabbedPane();
                        //tp.setBounds(0, 0, 500, 500);
                        //lec_details.add(tp);
                    JLabel id = new JLabel("Index No:" + "  " + rs.getString("index_no"));
                    id.setBounds(50, 50, 200, 30);
                    lec_details.add(id);
                    //p2.add(id);
                    JLabel name = new JLabel("   Name:" + "  " + rs.getString("name"));
                    name.setBounds(50, 100, 200, 30);
                    lec_details.add(name);

                    JLabel se = new JLabel("Subject Enrolment");
                    se.setBounds(50,150,210,30);
                    lec_details.add(se);
                    //p2.add(name);
                    //tp.add("Subject Enrolment", p1);
                    //tp.add("Profile", p2);

                        if (rs.getInt("SENG_11111") == 1) {
                            JLabel Sub1 = new JLabel("SENG 11111-Object Oriented Programming");
                            Sub1.setBounds(50, 200, 300, 30);
                            lec_details.add(Sub1);
                            //p1.add(Sub1);
                        }
                        if (rs.getInt("SENG_11112") == 1) {
                            JLabel Sub2 = new JLabel("SENG 11112-Introduction to Databases");
                            Sub2.setBounds(50, 230, 300, 30);
                            lec_details.add(Sub2);
                            //p1.add(Sub2);
                        }
                        if (rs.getInt("SENG_11113") == 1) {
                            JLabel Sub3 = new JLabel("SENG 11113-Project Management");
                            Sub3.setBounds(50, 260, 300, 30);
                            lec_details.add(Sub3);
                            //p1.add(Sub3);

                        }





                        lec_details.setLayout(null);
                        lec_details.setVisible(true);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

            public void SignUp(){
                JFrame lecturer = new JFrame("University Management System");
                lecturer.setSize(600, 600);

                JLabel name = new JLabel("Name");
                name.setBounds(100, 100, 80, 30);
                JTextField txtName = new JTextField(20);
                txtName.setBounds(300, 100, 150, 30);
                JLabel index = new JLabel("Index No");
                index.setBounds(100, 150, 80, 30);
                JTextField txtIndex = new JTextField(20);
                txtIndex.setBounds(300, 150, 150, 30);
                JLabel Username = new JLabel("Username");
                Username.setBounds(100, 200, 80, 30);
                JTextField txtUsername = new JTextField(20);
                txtUsername.setBounds(300, 200, 150, 30);
                JLabel Password = new JLabel("Password");
                Password.setBounds(100, 250, 90, 30);
                JPasswordField txtPassword = new JPasswordField(20);
                txtPassword.setBounds(300, 250, 150, 30);
                JLabel R_Password = new JLabel("Re type Password");
                R_Password.setBounds(100, 300, 90, 30);
                JPasswordField txt_R_Password = new JPasswordField(20);
                txt_R_Password.setBounds(300, 300, 150, 30);
                JLabel Subjects = new JLabel("Subjects");
                Subjects.setBounds(100, 350, 80, 30);
                JCheckBox S1 = new JCheckBox("SENG 11111-Object Oriented Programming");
                S1.setBounds(100, 380, 300, 30);
                JCheckBox S2 = new JCheckBox("SENG 11112-Introduction to Databases");
                S2.setBounds(100, 400, 300, 30);
                JCheckBox S3 = new JCheckBox("SENG 11113-Project Management");
                S3.setBounds(100, 420, 300, 30);
                JButton Signup = new JButton("Sign Up");
                Signup.setBounds(100, 470, 80, 30);

                lecturer.add(name);
                lecturer.add(txtName);
                lecturer.add(index);
                lecturer.add(txtIndex);
                lecturer.add(Username);
                lecturer.add(txtUsername);
                lecturer.add(Password);
                lecturer.add(txtPassword);
                lecturer.add(R_Password);
                lecturer.add(txt_R_Password);
                lecturer.add(Subjects);
                lecturer.add(S1);
                lecturer.add(S2);
                lecturer.add(S3);
                lecturer.add(Signup);

                lecturer.setLayout(null);
                lecturer.setVisible(true);
                Connection con = null;
                PreparedStatement pst = null;
                Signup.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            String query = "INSERT INTO `lecturer`(`index_no`, `name`, `Uname`, `Password`, `SENG_11111`, `SENG_11112`, `SENG_11113`) VALUES(?,?,?,?,?,?,?)";
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://127.0.0.1:3306/u_m_s?serverTimezone=UTC", "root", "");
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1, txtIndex.getText());
                            pst.setString(2, txtName.getText());
                            pst.setString(3, txtUsername.getText());
                            //if(txtPassword.getPassword()==txt_R_Password.getPassword())
                            pst.setString(4, String.valueOf(txt_R_Password.getPassword()));
                            //else
                            //JOptionPane.showMessageDialog(null,"Passwords are not matched");
                            if (S1.isSelected())
                                pst.setInt(5, 1);
                            else
                                pst.setInt(5, 0);
                            if (S2.isSelected())
                                pst.setInt(6, 1);
                            else
                                pst.setInt(6, 0);
                            if (S3.isSelected())
                                pst.setInt(7, 1);
                            else
                                pst.setInt(7, 0);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "You registered Successfully");
                            lecturer.dispose();


                            con.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                });


            }
        }


