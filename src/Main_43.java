import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class Main_43 {
    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "ensoxPER324");
        String sql = "CREATE TABLE IF NOT EXISTS names (`name` varchar(20), `id` INT primary key AUTO_INCREMENT);";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество имен");
        int n = sc.nextInt();
        String[] names = new String[n];
        System.out.println("Введите имена");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        System.out.println("Добавление в бд");
        for (String name : names) {
            stmt.executeUpdate("INSERT INTO names (`name`) VALUES ('" + name + "');");
        }
        ResultSet rs = stmt.executeQuery("SELECT * FROM names;");
        System.out.println("Вывод имен");
        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("id"));
        }
        rs.close();
        stmt.close();
        con.close();
        System.out.println("Завершение работы");

    }
}