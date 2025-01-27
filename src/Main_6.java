import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//
//15. Разработайте программу, которая выводит буквы английского алфавита, используя
//цикл while в MySQL/PostgreSQL.

public class Main_6 {
    public static void main(String[] args) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS alphabet (`char` varchar(20), `id` INT primary key AUTO_INCREMENT);";
        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        DriverManager.registerDriver(new Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ensoxPER324");
        Statement stmt = con.createStatement();
        stmt.execute(sql);


        int i = 0;
        while (i != alpabet.length()) {
            System.out.println(alpabet.charAt(i));
            stmt.execute("INSERT INTO alphabet (`char`) VALUES ('" + alpabet.charAt(i) + "')");
            i++;

        }

    }
}
