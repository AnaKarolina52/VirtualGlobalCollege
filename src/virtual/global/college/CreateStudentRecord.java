package virtual.global.college;
/**
 *
 * @author Ana Karolina Dias 20630
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import static java.time.Clock.system;
import java.util.Random;
import javax.swing.*;
import javax.swing.ImageIcon;


class CreateStudentRecord implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1,lab2;
    JTextField name,t2,t3,dob,address,phone,email,t8,t9,t10,t11;
    JButton b,b1,b2,b3;
    Choice subjectComboBox,courseComboBox;

    
      
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(first4);
    
    

    public CreateStudentRecord(){
        f = new JFrame("Add Student");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("virtual/global/college/icons/pictures/fifth.jpg"));
        Image i3 = img.getImage().getScaledInstance(1220, 700,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);
        
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


        id8 = new JLabel("New Student Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        name=new JTextField();
        name.setBounds(200,150,150,30);
        id15.add(name);

        id4= new JLabel("DOB (yyyy-mm-dd)");  
        id4.setBounds(400,150,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        dob=new JTextField();
        dob.setBounds(600,150,150,30);
        id15.add(dob);

        id5= new JLabel("Address");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        address=new JTextField();
        address.setBounds(200,200,150,30);
        id15.add(address);

        id6= new JLabel("Phone");
        id6.setBounds(400,200,200,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        phone=new JTextField();
        phone.setBounds(600,200,150,30);
        id15.add(phone);

        id7= new JLabel("Email");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        email=new JTextField();
        email.setBounds(200,250,150,30);
        id15.add(email);
        
       
        lab2=new JLabel("Course");
        lab2.setBounds(400,250,100,30);
	lab2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(lab2);
        
        //String course[] = {"Computer Science"};
        ///courseComboBox = new JComboBox(course);
        courseComboBox.setBackground(Color.WHITE);
        courseComboBox.setBounds(600,250,150,30);
        id15.add(courseComboBox);
        
        lab=new JLabel("Subject");
        lab.setBounds(50,300,100,30);
	lab.setFont(new Font("serif",Font.BOLD,20));
        id15.add(lab);
            
       // String subject[] = {"Front-End","Networking","Mobile Aplicattions","Programming"};
        //subjectComboBox = new JComboBox(subject);
        subjectComboBox.setBackground(Color.WHITE);
        subjectComboBox.setBounds(200,300,150,30);
        id15.add(subjectComboBox);
        
        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.BLACK);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        f.getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){
        
        String nameStr = name.getText();
        String dobStr = dob.getText();
        String addressStr = address.getText();
        String phoneStr = phone.getText();
        String emailStr = email.getText();
        String subjectStr = (String)subjectComboBox.getSelectedItem();
        String courseStr = (String)courseComboBox.getSelectedItem();
        
        if(ae.getSource() == b){
            try{
                datacom cc = new datacom();
                String q = "insert into student (`name`,`dob`,`address`,`phone`,"
                        + "`email`,`id_course`,`id_subject`,`id_login`)values('"
                        +nameStr+"','"+dobStr+"','"+addressStr+"','"
                        +phoneStr+"','"+emailStr+"',"+courseStr+","
                        +subjectStr+",1)";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                f.setVisible(false);
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Project().setVisible(true);
            
        }
    }
    public static void main(String[ ] arg){
        new CreateStudentRecord().f.setVisible(true);
    }
}




