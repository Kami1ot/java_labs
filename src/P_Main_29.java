//29. Реализовать класс P_Main_29 для работы с числами. Реализовать статический метод класса P_Main_29.round(), который округляет дробь до целого числа.
// Также статический метод abs(), который находит модуль числа. Статический метод P_Main_29.pow() для нахождения степени числа. Библиотеку Math не использовать.

public class P_Main_29 {

    public static int round(double number) {
        if (number >= 0) {
            return (int) (number + 0.5);
        } else {
            return (int) (number - 0.5);
        }
    }

    public static double abs(double number) {
        return number < 0 ? -number : number;
    }

    public static double pow(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double result = 1;
        boolean isNegativeExponent = exponent < 0;

        if (isNegativeExponent) {
            exponent = -exponent;
        }

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return isNegativeExponent ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println("Округление 3.6: " + P_Main_29.round(3.6));
        System.out.println("Округление -2.3: " + P_Main_29.round(-2.3));
        System.out.println("Модуль -5.5: " + P_Main_29.abs(-5.5));
        System.out.println("Модуль 4.0: " + P_Main_29.abs(4.0));
        System.out.println("2^3: " + P_Main_29.pow(2, 3));
        System.out.println("5^-2: " + P_Main_29.pow(5, -2));
        System.out.println("10^0: " + P_Main_29.pow(10, 0));
    }
}

