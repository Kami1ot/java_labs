import java.util.Arrays;
import java.util.Random;

//28. Создать класс Matrix для работы с двумерными матрицами. Создать методы для
//генерации нулевой матрицы, а также для генерации матрицы со случайными величинами –
//применить Math.random(). Реализовать метод сложения матриц.


public class P_Main_28 {
    private final int rows; // Количество строк
    private final int cols; // Количество столбцов
    private final int[][] data; // Двумерный массив для хранения данных матрицы

    // Конструктор: создает нулевую матрицу заданного размера
    public P_Main_28(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Размеры матрицы должны быть положительными числами.");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    // Метод для генерации случайной матрицы с целыми числами от 0 до maxValue
    public static P_Main_28 randomMatrix(int rows, int cols, int maxValue) {
        P_Main_28 PMain28 = new P_Main_28(rows, cols);
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                PMain28.data[i][j] = random.nextInt(maxValue + 1); // Генерация случайного числа от 0 до maxValue
            }
        }
        return PMain28;
    }

    // Метод для сложения двух матриц
    public P_Main_28 add(P_Main_28 other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для сложения.");
        }
        P_Main_28 result = new P_Main_28(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Метод для вывода матрицы в строковом представлении
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] row : data) {
            builder.append(Arrays.toString(row)).append("\n");
        }
        return builder.toString();
    }

    // Пример использования
    public static void main(String[] args) {
        // Создаем две случайные матрицы 3x3 с числами от 0 до 10
        P_Main_28 PMain281 = P_Main_28.randomMatrix(3, 3, 10);
        P_Main_28 PMain282 = P_Main_28.randomMatrix(3, 3, 10);

        // Выводим матрицы
        System.out.println("Матрица 1:");
        System.out.println(PMain281);

        System.out.println("Матрица 2:");
        System.out.println(PMain282);

        // Складываем матрицы
        P_Main_28 sumPMain28 = PMain281.add(PMain282);

        // Выводим результат сложения
        System.out.println("Результат сложения:");
        System.out.println(sumPMain28);
    }
}
