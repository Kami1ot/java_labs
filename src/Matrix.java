import java.util.Arrays;

public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    // Конструктор
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Конструктор для инициализации данными
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            this.data[i] = Arrays.copyOf(data[i], cols);
        }
    }

    // Сложение матриц
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для сложения");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Вычитание матриц
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для вычитания");
        }
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Умножение матрицы на число
    public Matrix multiplyByScalar(double scalar) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] * scalar;
            }
        }
        return new Matrix(result);
    }

    // Умножение двух матриц
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно совпадать с числом строк второй матрицы");
        }
        double[][] result = new double[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    // Транспонирование матрицы
    public Matrix transpose() {
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = this.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Возведение матрицы в степень
    public Matrix power(int exponent) {
        if (rows != cols) {
            throw new IllegalArgumentException("Матрица должна быть квадратной для возведения в степень");
        }
        Matrix result = new Matrix(this.data);
        Matrix base = new Matrix(this.data);

        for (int i = 1; i < exponent; i++) {
            result = result.multiply(base);
        }

        return result;
    }

    // Вывод матрицы
    public void print() {
        for (double[] row : data) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Тестирование класса Matrix
    public static void main(String[] args) {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("Матрица 2:");
        matrix2.print();

        System.out.println("Сложение матриц:");
        Matrix sum = matrix1.add(matrix2);
        sum.print();

        System.out.println("Вычитание матриц:");
        Matrix diff = matrix1.subtract(matrix2);
        diff.print();

        System.out.println("Умножение матрицы на число 2:");
        Matrix scalarProduct = matrix1.multiplyByScalar(2);
        scalarProduct.print();

        System.out.println("Произведение матриц:");
        Matrix product = matrix1.multiply(matrix2);
        product.print();

        System.out.println("Транспонированная матрица 1:");
        Matrix transposed = matrix1.transpose();
        transposed.print();

        System.out.println("Матрица 1 в степени 2:");
        Matrix powered = matrix1.power(2);
        powered.print();
    }
}
