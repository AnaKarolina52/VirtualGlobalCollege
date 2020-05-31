package virtual.global.college;

/**
 *
 * @author Ana Karolina 20630
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.ImageIcon;

public class TeacherInformation extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTable t1;
    JButton deleteBtn, addBtn, updateBtn;
    JTextField t2;
    String x[] = {"Name", "Date of Birth", "Address", "Phone", "Email", "Course", "Subject", "Id"};
    String y[][] = new String[20][13];
    int i = 0, j = 0;

    TeacherInformation() {
        super("Teacher Details");
        setSize(1260, 650);
        setLocation(200, 200);
        setLayout(null);

        l1 = new JLabel("Enter id number to delete Teacher : ");
        l1.setBounds(50, 360, 400, 30);
        l1.setFont(new Font("serif", Font.BOLD, 20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(400, 360, 200, 30);
        add(t2);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.BLACK);
        deleteBtn.setForeground(Color.BLACK);
        deleteBtn.setBounds(620, 360, 100, 30);
        add(deleteBtn);

        l2 = new JLabel("Add New Teacher");
        l2.setBounds(50, 450, 400, 30);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        add(l2);

        addBtn = new JButton("Add");
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.BLACK);
        addBtn.setBounds(300, 450, 150, 30);
        add(addBtn);

        l3 = new JLabel("Update Teacher Details");
        l3.setBounds(50, 490, 400, 30);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        add(l3);

        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.BLACK);
        updateBtn.setBounds(300, 490, 150, 30);
        add(updateBtn);

        deleteBtn.addActionListener(this);
        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);

        try {
            datacom c1 = new datacom();
            String s1 = "select * from teacher;";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("id_course");
                y[i][j++] = rs.getString("id_subject");
                y[i][j++] = rs.getString("id_teacher");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20, 20, 1200, 330);
        add(sp);

        getContentPane().setBackground(Color.WHITE);

        deleteBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        datacom c1 = new datacom();

        if (ae.getSource() == deleteBtn) {
            try {
                String a = t2.getText();
                String q = "delete from teacher where id_teacher = '" + a + "'";
                c1.s.executeUpdate(q);
                this.setVisible(false);
                new TeacherInformation().setVisible(true);
            } catch (Exception e) {
                 System.out.println(e.getMessage());
            }

        } else if (ae.getSource() == addBtn) {
            new CreateTeacherRecord().f.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == updateBtn) {
            new TeacherUpdate().f.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherInformation().setVisible(true);
    }

}
