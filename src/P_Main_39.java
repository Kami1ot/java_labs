// 39. Разработайте программу, которая заполняет список случайными числами. Количество элементов и числовой диапазон вводятся пользователем.
// Программа должна проверять, входит ли число (также вводится пользователем) в данный список. Должен быть реализован бинарный поиск.
// Результаты должны сохраняться в MySQL/PostgreSQL и выводиться оттуда же.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class P_Main_39 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Helper dbHelper = new Helper();

        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "root";

        dbHelper.Connection(url, user, password);

        String tableName = "RandomNumbers";
        dbHelper.execute_Update("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "number INT NOT NULL)");

        System.out.print("Введите количество элементов списка: ");
        int count = scanner.nextInt();

        System.out.print("Введите минимальное значение диапазона: ");
        int min = scanner.nextInt();

        System.out.print("Введите максимальное значение диапазона: ");
        int max = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }

        Collections.sort(numbers);

        System.out.println("Список чисел: " + numbers);

        dbHelper.execute_Update("TRUNCATE TABLE " + tableName);
        for (int number : numbers) {
            dbHelper.execute_Update("INSERT INTO " + tableName + " (number) VALUES (" + number + ")");
        }

        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();

        boolean found = binarySearch(numbers, target);

        if (found) {
            System.out.println("Число " + target + " найдено в списке.");
        } else {
            System.out.println("Число " + target + " не найдено в списке.");
        }

        dbHelper.rs_to_console("SELECT * FROM " + tableName);
    }

    public static boolean binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return true;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

