//23. Разработать программу, в которой требуется создать класс, описывающий геометрическую фигуру – треугольник.
// Методами класса должны быть – вычисление площади, периметра. Создать класс-наследник, определяющий прямоугольный треугольник.
import java.util.Scanner;

class Triangle {
    protected double sideA;
    protected double sideB;
    protected double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Стороны не образуют треугольник");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double calculateArea() {
        double semiPerimeter = calculatePerimeter() / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - sideA) *
                (semiPerimeter - sideB) *
                (semiPerimeter - sideC));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}

class RightTriangle extends Triangle {

    public RightTriangle(double sideA, double sideB, double sideC) {
        super(sideA, sideB, sideC);
        if (!isRightTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Стороны не образуют прямоугольный треугольник");
        }
    }

    private boolean isRightTriangle(double a, double b, double c) {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(sides[0] * sides[0] + sides[1] * sides[1] - sides[2] * sides[2]) < 1e-6; // Проверка теоремы Пифагора
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}

// Пример использования
public class P_Main_23 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            Triangle triangle = new Triangle(a, b, c);
            System.out.println(triangle);
            System.out.println("Периметр: " + triangle.calculatePerimeter());
            System.out.println("Площадь: " + triangle.calculateArea());

            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            RightTriangle rightTriangle = new RightTriangle(a, b, c);
            System.out.println(rightTriangle);
            System.out.println("Периметр: " + rightTriangle.calculatePerimeter());
            System.out.println("Площадь: " + rightTriangle.calculateArea());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
