package virtual.global.college;

/**
 *
 * @author Ana Karolina 20630
 */
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

class StudentUpdate implements ActionListener {

    JFrame f;
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id15, id16, id17, lab, lab1, lab2;
    JTextField name, dob, address, phone, email, idText;
    JButton submitBtn, cancelBtn, updateBtn, b3;
    Choice subjectComboBox, courseComboBox;

    StudentUpdate() {;
        f = new JFrame("Update Student details");
        f.setSize(900, 650);
        f.setLocation(450, 150);
        f.setBackground(Color.white);
        f.setLayout(null);

        JLabel id15 = new JLabel("Enter student id to update");
        id15.setBounds(50, 100, 500, 30);
        id15.setFont(new Font("serif", Font.ITALIC, 20));
        f.add(id15);

        idText = new JTextField();
        idText.setBounds(500, 100, 200, 30);
        f.add(idText);

        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.BLACK);
        updateBtn.setBounds(720, 100, 100, 30);
        f.add(updateBtn);
        updateBtn.addActionListener(this);

        id8 = new JLabel("Update Student Details:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        f.add(id8);

        id1 = new JLabel("Name");
        id1.setBounds(50, 150, 100, 30);
        id1.setFont(new Font("serif", Font.BOLD, 20));
        f.add(id1);

        name = new JTextField();
        name.setBounds(200, 150, 150, 30);
        f.add(name);

        id4 = new JLabel("DOB (yyyy-mm-dd)");
        id4.setBounds(400, 150, 200, 30);
        id4.setFont(new Font("serif", Font.BOLD, 20));
        f.add(id4);

        dob = new JTextField();
        dob.setBounds(600, 150, 150, 30);
        f.add(dob);

        id5 = new JLabel("Address");
        id5.setBounds(50, 200, 100, 30);
        id5.setFont(new Font("serif", Font.BOLD, 20));
        f.add(id5);

        address = new JTextField();
        address.setBounds(200, 200, 150, 30);
        f.add(address);

        id6 = new JLabel("Phone");
        id6.setBounds(400, 200, 200, 30);
        id6.setFont(new Font("serif", Font.BOLD, 20));
        f.add(id6);

        phone = new JTextField();
        phone.setBounds(600, 200, 150, 30);
        f.add(phone);

        id7 = new JLabel("Email");
        id7.setBounds(50, 250, 100, 30);
        id7.setFont(new Font("serif", Font.BOLD, 20));
        f.add(id7);

        email = new JTextField();
        email.setBounds(200, 250, 150, 30);
        f.add(email);

        subjectComboBox = new Choice();
        courseComboBox = new Choice();

        try {
            datacom c = new datacom();
            ResultSet rs = c.s.executeQuery("select id_subject from subject");
            while (rs.next()) {
                subjectComboBox.add(rs.getString("id_subject"));
            }
            ResultSet rs_sub = c.s.executeQuery("select id_course from course");
            while (rs_sub.next()) {
                courseComboBox.add(rs_sub.getString("id_course"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        lab2 = new JLabel("Course");
        lab2.setBounds(400, 250, 100, 30);
        lab2.setFont(new Font("serif", Font.BOLD, 20));
        f.add(lab2);

        courseComboBox.setBackground(Color.WHITE);
        courseComboBox.setBounds(600, 250, 150, 30);
        f.add(courseComboBox);

        lab = new JLabel("Subject");
        lab.setBounds(50, 300, 100, 30);
        lab.setFont(new Font("serif", Font.BOLD, 20));
        f.add(lab);

      
        subjectComboBox.setBackground(Color.WHITE);
        subjectComboBox.setBounds(200, 300, 150, 30);
        f.add(subjectComboBox);

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.BLACK);
        submitBtn.setBounds(250, 520, 150, 40);

        f.add(submitBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.BLACK);
        cancelBtn.setBounds(450, 520, 150, 40);

        f.add(cancelBtn);

        submitBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitBtn) {
            try {
                datacom con = new datacom();
                StringBuilder str = new StringBuilder();
                str.append("UPDATE `college1`.`student` SET ");
                str.append("`name` ='" + name.getText() + "' , ");
                str.append("`dob` = '" + dob.getText() + "', ");
                str.append("`address` = '" + address.getText() + "', ");
                str.append("`phone` = '" + phone.getText() + "', ");
                str.append("`email` = '" + email.getText() + "', ");
                str.append("`id_course` = " + courseComboBox.getSelectedItem() + ", ");
                str.append("`id_subject` = " + subjectComboBox.getSelectedItem() + ", ");
                str.append("`id_login` = 1 ");
                str.append("WHERE `id_student` = " + idText.getText() + ";");
                con.s.executeUpdate(str.toString());
                JOptionPane.showMessageDialog(null, "successfully updated");
                f.setVisible(false);
                new StudentInformation().setVisible(true);
            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == cancelBtn) {
            f.setVisible(false);
            new Project().setVisible(true);
        }
        if (ae.getSource() == updateBtn) {
            try {
                datacom con = new datacom();
                String str = "select name,dob,address,phone,email from student where id_student = " + idText.getText();
                ResultSet rs = con.s.executeQuery(str);

                if (rs.next()) {
                    f.setVisible(true);
                    name.setText(rs.getString(1));
                    dob.setText(rs.getString(2));
                    address.setText(rs.getString(3));
                    phone.setText(rs.getString(4));
                    email.setText(rs.getString(5));

                }

            } catch (Exception ex) {
            }

            f.setVisible(true);
            f.setSize(900, 650);
            f.setLocation(450, 250);
        }
    }

    public static void main(String[] arg) {
        new StudentUpdate().f.setVisible(true);
    }
}
