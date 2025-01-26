import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main_7 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ensoxPER324");
        String sql = "CREATE TABLE IF NOT EXISTS word (`word` varchar(20), `id` INT primary key AUTO_INCREMENT);";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < 6; i++) {
            System.out.println(s);
            stmt.execute("INSERT INTO word (`word`) VALUES ('" + s + "')");
        }
    }
}
