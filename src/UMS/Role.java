package UMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Role {
    public void SignIn() {
        JFrame role = new JFrame("University Management System");
        role.setSize(500, 500);
        JButton Lecturer = new JButton("Lecturer");
        JButton Student = new JButton("Student");
        Lecturer.setBounds(200, 100, 90, 30);
        Student.setBounds(200, 200, 90, 30);

        role.add(Lecturer);
        role.add(Student);

        Lecturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                role.dispose();
                Lecturer L1 = new Lecturer();
                L1.SignIn();
            }
        });
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                role.dispose();
                Student S1 = new Student();
                S1.SignIn();
            }
        });

        role.setLayout(null);
        role.setVisible(true);
    }
    public void SignUp() {
        JFrame role = new JFrame("University Management System");
        role.setSize(500, 500);
        JButton Lecturer = new JButton("Lecturer");
        JButton Student = new JButton("Student");
        Lecturer.setBounds(200, 100, 90, 30);
        Student.setBounds(200, 200, 90, 30);
        
        role.add(Lecturer);
        role.add(Student);

        Lecturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                role.dispose();
                Lecturer L1 = new Lecturer();
                L1.SignUp();
            }
        });
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                role.dispose();
                Student S1 = new Student();
                S1.SignUp();

            }
        });

        role.setLayout(null);
        role.setVisible(true);
    }
}
