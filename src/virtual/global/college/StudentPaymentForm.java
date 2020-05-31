package virtual.global.college;

/**
 *
 * @author Ana Karolina 20630
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class StudentPaymentForm extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField makeP, name;
    private JComboBox yearComboBox;
    private Choice subjectComboBox, courseComboBox;
    JButton payButton, backButton;
    Choice idStudentCombobox;

    public static void main(String[] args) {
        new StudentPaymentForm().setVisible(true);
    }

    public StudentPaymentForm() {
        super("Student Fee Form");
        setBounds(700, 200, 550, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        idStudentCombobox = new Choice();
        idStudentCombobox.setForeground(new Color(47, 79, 79));
        idStudentCombobox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));

        try {
            datacom c = new datacom();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                idStudentCombobox.add(rs.getString("id_student"));
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }

        JLabel l1 = new JLabel("Select Student Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 63, 102, 22);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 97, 102, 22);
        contentPane.add(l2);

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

        JLabel l4 = new JLabel("Subject");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 209, 102, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Year");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 242, 102, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Total Payable");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 275, 102, 22);
        contentPane.add(l6);

        idStudentCombobox.setBounds(174, 66, 156, 20);
        contentPane.add(idStudentCombobox);

        name = new JTextField();
        name.setEditable(false);
        name.setForeground(new Color(47, 79, 79));
        name.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        name.setColumns(10);
        name.setBounds(174, 100, 156, 20);
        contentPane.add(name);

        try {
            datacom c = new datacom();
            ResultSet rs = c.s.executeQuery("select * from student where id_student = '" + idStudentCombobox.getSelectedItem() + "'");
            while (rs.next()) {
                name.setText(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentPaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idStudentCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    datacom c = new datacom();
                    ResultSet rs = c.s.executeQuery("select * from student where id_student = '" + idStudentCombobox.getSelectedItem() + "'");
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(StudentPaymentForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //subjectComboBox = new JComboBox();
        //subjectComboBox.setModel(new DefaultComboBoxModel(new String[]{"Front-End", "Networking", "Mobile Aplicattions", "Programming"}));
        subjectComboBox.setForeground(new Color(47, 79, 79));
        subjectComboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        subjectComboBox.setBounds(176, 211, 154, 20);
        contentPane.add(subjectComboBox);

        yearComboBox = new JComboBox();
        yearComboBox.setModel(new DefaultComboBoxModel(new String[]{"1st", "2nd", "3rd", "4th"}));
        yearComboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        yearComboBox.setForeground(new Color(47, 79, 79));
        yearComboBox.setBounds(176, 244, 154, 20);
        contentPane.add(yearComboBox);

        makeP = new JTextField();
        makeP.setForeground(new Color(47, 79, 79));
        makeP.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        makeP.setColumns(10);
        makeP.setBounds(176, 275, 154, 20);
        add(makeP);

        payButton = new JButton("Pay");
        payButton.addActionListener(this);
        payButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        payButton.setBounds(64, 321, 111, 33);
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.BLACK);
        contentPane.add(payButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        backButton.setBounds(198, 321, 111, 33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.BLACK);
        contentPane.add(backButton);

        JLabel l7 = new JLabel("Course");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 173, 102, 22);
        contentPane.add(l7);

        //CourseComboBox = new JComboBox();
        //CourseComboBox.setModel(new DefaultComboBoxModel(new String[]{"Computer Science"}));
        courseComboBox.setForeground(new Color(47, 79, 79));
        courseComboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        courseComboBox.setBounds(176, 176, 154, 20);
        contentPane.add(courseComboBox);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Fee-Form",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
        panel.setBackground(new Color(211, 211, 211));
        panel.setBounds(10, 38, 358, 348);

        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        contentPane.add(panel);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == payButton) {
                try {
                    datacom con = new datacom();
                    String sql = "INSERT INTO fee" + "(`id_student`," + "`id_course`," + "`id_subject`,"
                            + "`semester`,`fee_paid`) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, idStudentCombobox.getSelectedItem());
                    //st.setString(2, name.getText());
                    st.setString(2, (String) courseComboBox.getSelectedItem());
                    st.setString(3, (String) subjectComboBox.getSelectedItem());
                    st.setString(4, (String) yearComboBox.getSelectedItem());
                    st.setString(5, makeP.getText());

                    int i = st.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Paid");
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "error");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (ae.getSource() == backButton) {
                this.setVisible(false);
            }
        } catch (Exception e) {
 System.out.println(e.getMessage());
        }
    }
}
