import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите первое число:");
            double number1 = getValidDouble(scanner);

            System.out.println("Введите второе число:");
            double number2 = getValidDouble(scanner);

            System.out.println("Выберите операцию (сложение, вычитание, умножение, деление, степень, логарифм):");
            String operation = scanner.nextLine().toLowerCase();

            double result;
            switch (operation) {
                case "сложение":
                    result = number1 + number2;
                    break;
                case "вычитание":
                    result = number1 - number2;
                    break;
                case "умножение":
                    result = number1 * number2;
                    break;
                case "деление":
                    if (number2 == 0) {
                        throw new ArithmeticException("Деление на ноль невозможно.");
                    }
                    result = number1 / number2;
                    break;
                case "степень":
                    result = Math.pow(number1, number2);
                    break;
                case "логарифм":
                    if (number1 <= 0 || number2 <= 0 || number2 == 1) {
                        throw new ArithmeticException("Логарифм возможен только для положительных чисел, а основание не может быть равно 1.");
                    }
                    result = Math.log(number1) / Math.log(number2);
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция. Пожалуйста, выберите одну из указанных операций.");
            }

            System.out.println("Результат: " + result);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
                writer.write("Результат операции (" + operation + "): " + result);
            }
            System.out.println("Результат сохранен в файл result.txt.");

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введены некорректные данные. Введите числа.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число.");
            }
        }
    }
}

