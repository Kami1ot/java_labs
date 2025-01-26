// 46. Написать приложение для сложения, вычитания, умножения, деления, возведения в степень логарифмов.
// Программа должна выполнять ввод данных, проверку правильности введенных данных, выдачу сообщений в случае ошибок. Результат выводится на экран и записывается в файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P_Main_46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");
            System.out.println("5 - Возведение в степень");
            System.out.println("6 - Логарифм");
            System.out.println("7 - Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                double result = 0;

                if (choice >= 1 && choice <= 5) {
                    System.out.print("Введите первое число: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double num2 = scanner.nextDouble();

                    switch (choice) {
                        case 1 -> {
                            result = num1 + num2;
                            saveToFile("Сложение", num1, num2, result);
                        }
                        case 2 -> {
                            result = num1 - num2;
                            saveToFile("Вычитание", num1, num2, result);
                        }
                        case 3 -> {
                            result = num1 * num2;
                            saveToFile("Умножение", num1, num2, result);
                        }
                        case 4 -> {
                            if (num2 == 0) {
                                throw new ArithmeticException("Деление на ноль.");
                            }
                            result = num1 / num2;
                            saveToFile("Деление", num1, num2, result);
                        }
                        case 5 -> {
                            result = Math.pow(num1, num2);
                            saveToFile("Возведение в степень", num1, num2, result);
                        }
                    }
                } else if (choice == 6) {
                    System.out.print("Введите число для логарифма: ");
                    double num = scanner.nextDouble();
                    if (num <= 0) {
                        throw new ArithmeticException("Логарифм возможен только для положительных чисел.");
                    }
                    System.out.print("Введите основание логарифма: ");
                    double base = scanner.nextDouble();
                    if (base <= 0 || base == 1) {
                        throw new ArithmeticException("Основание логарифма должно быть положительным и не равным 1.");
                    }

                    result = log(num, base);
                    saveToFile("Логарифм", num, base, result);
                } else {
                    System.out.println("Некорректный выбор. Повторите ввод.");
                    continue;
                }

                System.out.println("Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
                saveToFile(e.getMessage());
            } catch (Exception e) {
                System.out.println("Некорректный ввод данных.");
                saveToFile("Некорректный ввод данных.");
            }
        }

        scanner.close();
    }

    private static double log(double num, double base) {
        return Math.log(num) / Math.log(base);
    }

    private static void saveToFile(String operation, double num1, double num2, double result) {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write(operation + ": " + num1 + ", " + num2 + " => Результат: " + result + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private static void saveToFile(String errorMessage) {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write("Ошибка" + ": " + errorMessage + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
