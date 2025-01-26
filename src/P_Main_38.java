// 38. Напишите программу, которая заполняет списочный массив случайными числами типа Integer (значения этих чисел были от 1 до 100).
// Список должен содержать 100 элементов. Затем отсортируйте по убыванию список и выведите первые 10 значений в консоль. Результатыы сохраните в MySQL/PostgreSQL.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class P_Main_38 {

    public static void main(String[] args) throws Exception {
        Helper dbHelper = new Helper();

        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "root";

        dbHelper.Connection(url, user, password);

        String tableName = "TopNumbers";
        dbHelper.execute_Update("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "number INT NOT NULL)");

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        numbers.sort(Collections.reverseOrder());
        List<Integer> top10 = numbers.subList(0, 10);

        System.out.println("Топ-10 значений:");
        for (int number : top10) {
            System.out.println(number);
        }

        dbHelper.execute_Update("TRUNCATE TABLE " + tableName);

        for (int number : top10) {
            dbHelper.execute_Update("INSERT INTO " + tableName + " (number) VALUES (" + number + ")");
        }

        System.out.println("Топ-10 чисел сохранены в таблицу '" + tableName + "'.");
        dbHelper.rs_to_console("SELECT * FROM " + tableName);
    }
}
