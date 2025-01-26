// 32. Разработать класс для представления комплексных чисел с возможностью задания вещественной и мнимой частей в виде массива из двух чисел типа int.
// Определить методы для выполнения операций сложения, вычитания и умножения комплексных чисел.

public class P_Main_32 {
    private final int real;
    private final int imaginary;

    public P_Main_32(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public P_Main_32(int[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException("Массив должен содержать два элемента: вещественную и мнимую части.");
        }
        this.real = parts[0];
        this.imaginary = parts[1];
    }

    public P_Main_32 add(P_Main_32 other) {
        return new P_Main_32(this.real + other.real, this.imaginary + other.imaginary);
    }

    public P_Main_32 subtract(P_Main_32 other) {
        return new P_Main_32(this.real - other.real, this.imaginary - other.imaginary);
    }

    public P_Main_32 multiply(P_Main_32 other) {
        int realPart = this.real * other.real - this.imaginary * other.imaginary;
        int imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new P_Main_32(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return real + (imaginary >= 0 ? " + " : " - ") + Math.abs(imaginary) + "i";
    }

    public static void main(String[] args) {
        P_Main_32 num1 = new P_Main_32(new int[]{3, 4});
        P_Main_32 num2 = new P_Main_32(new int[]{1, -2});

        System.out.println("Число 1: " + num1);
        System.out.println("Число 2: " + num2);

        System.out.println("Сумма: " + num1.add(num2));
        System.out.println("Разность: " + num1.subtract(num2));
        System.out.println("Произведение: " + num1.multiply(num2));
    }
}
