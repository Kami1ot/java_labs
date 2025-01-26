//24. Разработать программу, в которой требуется создать абстрактный класс. В этом абстрактном классе определить абстрактные методы вычисления функции в определенной точке.
// Создать классы-наследники абстрактного класса, описывающими уравнения прямой и параболы. Программа должна выводить в консоль значение функции при вводе определенного значения.

import java.util.Scanner;

abstract class Function {
    public abstract double calculate(double x);
}

// Класс-наследник для уравнения прямой (y = kx + b)
class LineEquation extends Function {
    private final double k;
    private final double b;

    public LineEquation(double k, double b) {
        this.k = k;
        this.b = b;
    }

    @Override
    public double calculate(double x) {
        return k * x + b;
    }

    @Override
    public String toString() {
        return "Уравнение прямой: y = " + k + "x + " + b;
    }
}

// Класс-наследник для уравнения параболы (y = ax^2 + bx + c)
class ParabolaEquation extends Function {
    private final double a;
    private final double b;
    private final double c;

    public ParabolaEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculate(double x) {
        return a * x * x + b * x + c;
    }

    @Override
    public String toString() {
        return "Уравнение параболы: y = " + a + "x^2 + " + b + "x + " + c;
    }
}

public class P_Main_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффициенты для уравнения прямой (y = kx + b):");
        System.out.print("k: ");
        double k = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        Function line = new LineEquation(k, b);

        System.out.println("Введите коэффициенты для уравнения параболы (y = ax^2 + bx + c):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double parabolaB = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        Function parabola = new ParabolaEquation(a, parabolaB, c);

        System.out.print("Введите значение x для вычисления функций: ");
        double x = scanner.nextDouble();

        System.out.println(line);
        System.out.println("Значение функции в точке x = " + x + ": " + line.calculate(x));
        System.out.println(parabola);
        System.out.println("Значение функции в точке x = " + x + ": " + parabola.calculate(x));
    }
}
