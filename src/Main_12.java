import java.util.Scanner;

public class Main_12 {
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Базовый случай: факториал 0 и 1 равен 1
        }
        return n * factorial(n - 1); // Рекурсивный вызов
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число для вычисления факториала:");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Факториал отрицательного числа не существует.");
        } else {
            long result = factorial(number);
            System.out.println("Факториал числа " + number + " равен " + result);
        }

        scanner.close();
    }
}
