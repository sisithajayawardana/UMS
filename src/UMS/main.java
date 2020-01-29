package UMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class main {

    public static void main(String[] args) {
        JFrame sign = new JFrame("University Management System");
        sign.setSize(500, 500);
        JLabel welcome = new JLabel("Welcome to University Management System");
        welcome.setBounds(120,30,250,50);
        JButton SignIn = new JButton("Sign In");
        JButton SignUp = new JButton("Sign Up");
        SignIn.setBounds(200, 100, 90, 30);
        SignUp.setBounds(200, 200, 90, 30);

        ImageIcon icon = new ImageIcon("G:\\java\\ums\\1.jpg");
        JLabel label = new JLabel(icon);
        sign.add(label);

        sign.setLayout(null);
        sign.setVisible(true);

        sign.add(SignIn);
        sign.add(SignUp);
        sign.add(welcome);
        SignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sign.dispose();
                Role R1 = new Role();
                R1.SignIn();
            }
        });
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sign.dispose();
                Role R1 = new Role();
                R1.SignUp();
            }
        });


    }



}




