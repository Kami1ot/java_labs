//Напишите программу, которая получает в качестве входных данных два числа. Эти
//числа являются количество строк и столбцов двумерной коллекции целых чисел. Далее элементы
//заполняются случайными числами и выводятся в консоль в виде таблицы.

import java.util.Random;
import java.util.Scanner;

public class Main_41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк:");
        int rows = scanner.nextInt();

        System.out.println("Введите количество столбцов:");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Количество строк и столбцов должно быть больше 0.");
            return;
        }

        int[][] matrix = new int[rows][cols];

        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Случайные числа от 0 до 99
            }
        }

        // Вывод массива в виде таблицы
        System.out.println("Сгенерированная таблица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
