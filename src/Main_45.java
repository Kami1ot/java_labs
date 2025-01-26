import java.io.*;
import java.util.Scanner;

public class Main_45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Запрос имени файла
            System.out.println("Введите название файла (например, 1.txt):");
            String inputFileName = scanner.nextLine();

            // Проверка существования файла
            File inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
                System.out.println("Файл не найден: " + inputFileName);
                return;
            }

            // Чтение данных из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            double number1 = Double.parseDouble(reader.readLine());
            double number2 = Double.parseDouble(reader.readLine());
            reader.close();

            // Запрос операции
            System.out.println("Введите операцию (сложение, умножение, разность):");
            String operation = scanner.nextLine().toLowerCase();

            // Выполнение операции
            double result;
            switch (operation) {
                case "сложение":
                    result = number1 + number2;
                    break;
                case "умножение":
                    result = number1 * number2;
                    break;
                case "разность":
                    result = number1 - number2;
                    break;
                default:
                    System.out.println("Неверная операция.");
                    return;
            }

            // Вывод результата на экран
            System.out.println("Результат: " + result);

            // Запись результата в файл
            String outputFileName = inputFileName.replace(".txt", "_out.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write("Результат операции: " + result);
            writer.close();

            System.out.println("Результат сохранен в файл: " + outputFileName);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: файл содержит некорректные данные.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
