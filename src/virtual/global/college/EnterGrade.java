package virtual.global.college;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author Ana Karolina 20630
 */
public class EnterGrade extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JButton b1;
    Choice idStudentCombobox, subject1, subject2, subject3, subject4, subject5;

    EnterGrade() {
        setLayout(new GridLayout(4, 2, 50, 50));
        idStudentCombobox = new Choice();
        subject1 = new Choice();
        subject2 = new Choice();
        subject3 = new Choice();
        subject4 = new Choice();
        subject5 = new Choice();

        try {
            datacom c = new datacom();
            ResultSet rs = c.s.executeQuery("select id_student from student");
            while (rs.next()) {
                idStudentCombobox.add(rs.getString("id_student"));
            }
            ResultSet rs_sub = c.s.executeQuery("select id_subject from subject");
            while (rs_sub.next()) {
                subject1.add(rs_sub.getString("id_subject"));
                subject2.add(rs_sub.getString("id_subject"));
                subject3.add(rs_sub.getString("id_subject"));
                subject4.add(rs_sub.getString("id_subject"));
                subject5.add(rs_sub.getString("id_subject"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setSize(500, 550);
        setLocation(400, 200);
        setLayout(null);

        l1 = new JLabel("Enter Student Grades");
        l1.setFont(new Font("serif", Font.BOLD, 30));
        l1.setBounds(50, 0, 500, 80);
        add(l1);

        l2 = new JLabel("Enter Student Number");
        l2.setBounds(50, 70, 200, 40);
        add(l2);

        idStudentCombobox.setBounds(280, 80, 200, 20);
        add(idStudentCombobox);

        l3 = new JLabel("Enter Subject");
        l3.setBounds(50, 150, 200, 40);
        add(l3);

        l4 = new JLabel("Enter Grade");
        l4.setBounds(250, 150, 200, 40);
        add(l4);

        subject1.setBounds(50, 200, 200, 20);
        add(subject1);

        t3 = new JTextField();
        t3.setBounds(250, 200, 200, 20);
        add(t3);

        subject2.setBounds(50, 230, 200, 20);
        add(subject2);

        t5 = new JTextField();
        t5.setBounds(250, 230, 200, 20);
        add(t5);

        subject3.setBounds(50, 260, 200, 20);
        add(subject3);

        t7 = new JTextField();
        t7.setBounds(250, 260, 200, 20);
        add(t7);

        subject4.setBounds(50, 290, 200, 20);
        add(subject4);

        t9 = new JTextField();
        t9.setBounds(250, 290, 200, 20);
        add(t9);

        subject5.setBounds(50, 320, 200, 20);
        add(subject5);

        t11 = new JTextField();
        t11.setBounds(250, 320, 200, 20);
        add(t11);

        b1 = new JButton("Submit");
        b1.setBounds(50, 360, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        add(b1);

        b1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                datacom c1 = new datacom();
                String s2 = "insert into grade (`id_student`,`id_subject`,`grade`) values(" + idStudentCombobox.getSelectedItem() + "," + subject1.getSelectedItem() + "," + t3.getText() + ")";
                String s3 = "insert into grade (`id_student`,`id_subject`,`grade`) values(" + idStudentCombobox.getSelectedItem() + "," + subject2.getSelectedItem() + "," + t5.getText() + ")";
                String s4 = "insert into grade (`id_student`,`id_subject`,`grade`) values(" + idStudentCombobox.getSelectedItem() + "," + subject3.getSelectedItem() + "," + t7.getText() + ")";
                String s5 = "insert into grade (`id_student`,`id_subject`,`grade`) values(" + idStudentCombobox.getSelectedItem() + "," + subject4.getSelectedItem() + "," + t9.getText() + ")";
                String s6 = "insert into grade (`id_student`,`id_subject`,`grade`) values(" + idStudentCombobox.getSelectedItem() + "," + subject5.getSelectedItem() + "," + t11.getText() + ")";

                c1.s.executeUpdate(s2);
                c1.s.executeUpdate(s3);
                c1.s.executeUpdate(s4);
                c1.s.executeUpdate(s5);
                c1.s.executeUpdate(s6);

                JOptionPane.showMessageDialog(null, "Grade Inserted Successfully");
                this.setVisible(false);

            }
        } catch (Exception e) {
            System.out.println("The error is:" + e);
        }
    }

    public static void main(String[] args) {
        new EnterGrade().setVisible(true);
    }
}
