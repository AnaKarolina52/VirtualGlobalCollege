package virtual.global.college;

/**
 *
 * @author Ana Karolina 20630
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class VirtualGlobalCollege {

    public static void main(String s[]) {
        Frame f = new Frame("Virtual Global College");
        //f.setVisible(true); 
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 4, x += 1) {
            f.setLocation((800 - ((i + x) / 2)), 500 - (i / 2));
            f.setSize(i + 3 * x, i + x / 2);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                 System.out.println(e.getMessage());
            }
        }
    }
}

class Frame extends JFrame implements Runnable {

    Thread t1;

    Frame(String s) {
        super(s);
        setLayout(new FlowLayout());
        //ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("virtual/global/college/icons/pictures/first.jpg"));
        //Image i1 = c1.getImage().getScaledInstance(1000, 700,Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i1);

        //JLabel m1 = new JLabel(i2);
        //add(m1);
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);
            Password f1 = new Password();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
