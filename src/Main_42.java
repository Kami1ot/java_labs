import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Разработайте программу, которая получает в качестве параметра два числа –
//количество строк и столбцов двумерной коллекции целых чисел. Коллекция заполняется
//        случайными числами, после чего на экран выводятся максимальное и минимальное значения с
//индексами ячеек.
public class Main_42 {
    public static void main(String[] args) {
        System.out.println("he");
        Scanner scanner = new Scanner(System.in);

        // Ввод количества строк и столбцов
        System.out.println("Введите количество строк:");
        int rows = scanner.nextInt();

        System.out.println("Введите количество столбцов:");
        int cols = scanner.nextInt();

        // Проверка на корректность ввода
        if (rows <= 0 || cols <= 0) {
            System.out.println("Количество строк и столбцов должно быть больше 0.");
            return;
        }

        // Инициализация матрицы
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        // Заполнение матрицы случайными числами и вывод на экран
        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Случайные числа от 0 до 99
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.stream(matrix[0]).max());

        // Поиск минимального и максимального значений
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minRow = -1, minCol = -1, maxRow = -1, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Вывод результатов
        System.out.println("\nМинимальное значение: " + min + " (строка: " + minRow + ", столбец: " + minCol + ")");
        System.out.println("Максимальное значение: " + max + " (строка: " + maxRow + ", столбец: " + maxCol + ")");

        scanner.close();
    }
}
