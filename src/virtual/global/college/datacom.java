package virtual.global.college;

/**
 *
 * @author Ana Karolina 20630
 */
import java.sql.*;

public class datacom {

    Connection c;
    Statement s;

    public datacom() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/college1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "AK101287");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
