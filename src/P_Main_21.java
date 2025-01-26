//21. Разработать класс-оболочку для числового типа double. Реализовать статические методы сложения, деления, возведения в степень.

public class P_Main_21 {
        private double value;

        public P_Main_21(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public static double add_double(double a, double b) {
            return a + b;
        }

        public static double divide(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль невозможно");
            }
            return a / b;
        }

        public static double power(double base, double exponent) {
            return Math.pow(base, exponent);
        }

        @Override
        public String toString() {
            return "Double{value=" + value + "}";
        }

        public static void main(String[] args) {
            double sum = P_Main_21.add_double(5.5, 3.3);
            System.out.println("Сумма: " + sum);

            double division = P_Main_21.divide(10.0, 2.0);
            System.out.println("Деление: " + division);

            double power = P_Main_21.power(2.0, 3.0);
            System.out.println("Возведение в степень: " + power);

            P_Main_21 wrapper = new P_Main_21(42.0);
            System.out.println("Оболочка: " + wrapper);

            wrapper.setValue(99.9);
            System.out.println("Новое значение: " + wrapper.getValue());
        }
    }
