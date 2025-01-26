// 25. Создать интерфейс Progress c методами вычисления любого элемента прогрессии и суммы прогрессии.
// Разработать классы арифметической и геометрической прогрессии, которые имплементируют интерфейс Progress.

interface Progress {
    double calculateElement(int n);

    double calculateSum(int n);
}

class ArithmeticProgression implements Progress {
    private final double firstElement;
    private final double difference;

    public ArithmeticProgression(double firstElement, double difference) {
        this.firstElement = firstElement;
        this.difference = difference;
    }

    @Override
    public double calculateElement(int n) {
        return firstElement + (n - 1) * difference;
    }

    @Override
    public double calculateSum(int n) {
        double lastElement = calculateElement(n);
        return (firstElement + lastElement) * n / 2;
    }

    @Override
    public String toString() {
        return "Арифметическая прогрессия (a = " + firstElement + ", d = " + difference + ")";
    }
}

class GeometricProgression implements Progress {
    private final double firstElement;
    private final double ratio;

    public GeometricProgression(double firstElement, double ratio) {
        this.firstElement = firstElement;
        this.ratio = ratio;
    }

    @Override
    public double calculateElement(int n) {
        return firstElement * Math.pow(ratio, n - 1);
    }

    @Override
    public double calculateSum(int n) {
        if (ratio == 1) {
            return firstElement * n;
        }
        return firstElement * (1 - Math.pow(ratio, n)) / (1 - ratio);
    }

    @Override
    public String toString() {
        return "Геометрическая прогрессия (a = " + firstElement + ", r = " + ratio + ")";
    }
}

public class P_Main_25 {
    public static void main(String[] args) {
        Progress arithmetic = new ArithmeticProgression(2, 3);
        Progress geometric = new GeometricProgression(3, 2);

        System.out.println(arithmetic);
        System.out.println("5-й элемент (арифметическая): " + arithmetic.calculateElement(5));
        System.out.println("Сумма первых 5 элементов (арифметическая): " + arithmetic.calculateSum(5));

        System.out.println(geometric);
        System.out.println("5-й элемент (геометрическая): " + geometric.calculateElement(5));
        System.out.println("Сумма первых 5 элементов (геометрическая): " + geometric.calculateSum(5));
    }
}
