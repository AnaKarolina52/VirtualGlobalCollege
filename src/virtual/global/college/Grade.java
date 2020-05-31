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

public class Grade extends JFrame {

    JTextArea t1;
    JPanel p1;

    Grade() {
    }

    Grade(String str) {
        setSize(500, 600);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        t1 = new JTextArea(50, 15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif", Font.ITALIC, 18));

        add(p1, "North");

        add(jsp, "Center");

        setLocation(450, 200);
        mark(str);
    }

    public void mark(String s) {
        try {
            datacom c = new datacom();

            t1.setText("\tResult of Examination\n\nSubject\n");

            String strSubject = null;

            ResultSet rs2 = c.s.executeQuery("select * from grade where id_student=" + s);

            while (rs2.next()) {
                t1.append("\nGrade\n\n\t" + rs2.getString("grade"));
                t1.append("\n-----------------------------------------");
                t1.append("\n");
                strSubject = rs2.getString("id_subject");
            }
            ResultSet rs1 = c.s.executeQuery("select * from subject where id_subject=" + strSubject);

            while (rs1.next()) {
                t1.append("\n\t" + rs1.getString("name"));
                t1.append("\n-----------------------------------------");
                t1.append("\n");
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Grade().setVisible(true);
    }
}
