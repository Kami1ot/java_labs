// 36. Создайте класс P_Main_36 для конвертации десятичного числа в бинарный, восьмеричный, шестнадцатеричный вид.
// Реализовать в виде статических методов класса. Числа вводятся с клавиатуры с запросом в какой численный вид конвертировать.

import java.util.Scanner;

public class P_Main_36 {

    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public static String toHexadecimal(int number) {
        return Integer.toHexString(number).toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Выберите, в какой вид конвертировать (binary, octal, hexadecimal): ");
        String choice = scanner.next().toLowerCase();

        switch (choice) {
            case "binary":
                System.out.println("Бинарное представление: " + toBinary(decimalNumber));
                break;
            case "octal":
                System.out.println("Восьмеричное представление: " + toOctal(decimalNumber));
                break;
            case "hexadecimal":
                System.out.println("Шестнадцатеричное представление: " + toHexadecimal(decimalNumber));
                break;
            default:
                System.out.println("Некорректный выбор.");
        }

        scanner.close();
    }
}

