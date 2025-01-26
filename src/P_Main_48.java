// 48. Разработать программу нахождения наибольшего общего делителя двух натуральных чисел. Требуется реализовать рекурсивный и без рекурсии варианты.
// Результат сохранить в MySQL/PostgreSQL.

import java.util.Scanner;

public class P_Main_48 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Helper dbHelper = new Helper();
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        dbHelper.Connection(url, user, password);

        String tableName = "GCDResults";
        dbHelper.execute_Update("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "number1 INT NOT NULL, " +
                "number2 INT NOT NULL, " +
                "gcd_recursive INT NOT NULL, " +
                "gcd_iterative INT NOT NULL)");

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        if (num1 <= 0 || num2 <= 0) {
            System.out.println("Оба числа должны быть натуральными.");
            return;
        }

        int gcdRecursive = gcdRecursive(num1, num2);
        int gcdIterative = gcdIterative(num1, num2);

        System.out.println("НОД (рекурсия): " + gcdRecursive);
        System.out.println("НОД (без рекурсии): " + gcdIterative);

        dbHelper.execute_Update("INSERT INTO " + tableName + " (number1, number2, gcd_recursive, gcd_iterative) VALUES (" +
                num1 + ", " + num2 + ", " + gcdRecursive + ", " + gcdIterative + ")");

        System.out.println("Результаты сохранены в базу данных.");
        dbHelper.rs_to_console("SELECT * FROM " + tableName);
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

