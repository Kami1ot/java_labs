//22. Разработать программу, которая заполняет двумерный массив случайными положительными числами в диапазоне от 1 до 100 до тех пор,
// пока сумма граничных элементов не станет равной 666. Пользователь вначале вводит размер матрицы.


import java.util.Random;
import java.util.Scanner;

public class P_Main_22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        if (rows < 3 || cols < 3) {
            System.out.println("Размер матрицы должен быть не менее 3x2.");
            return;
        }

        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        int boundarySum = 0;
        while (boundarySum != 666) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = random.nextInt(100) + 1; // Случайное число от 1 до 100
                }
            }

            boundarySum = calculateBoundarySum(matrix);
        }

        System.out.println("Матрица, где сумма граничных элементов равна 666:");
        printMatrix(matrix);
    }

    private static int calculateBoundarySum(int[][] matrix) {
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            sum += matrix[0][j];
        }

        for (int j = 0; j < cols; j++) {
            sum += matrix[rows - 1][j];
        }

        for (int i = 1; i < rows - 1; i++) {
            sum += matrix[i][0];
            sum += matrix[i][cols - 1];
        }

        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
    }
}

