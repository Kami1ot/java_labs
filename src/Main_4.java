import java.util.HashMap;
import java.util.Scanner;


//13. Написать калькулятор для строковых выражений вида "<число> <операция>
//<число>", где <число> - положительное целое число меньшее 10, записанное словами, например,
//        "четыре", <арифметическая операция> - одна из операций "плюс", "минус", "умножить".
//Результат выполнения операции вернуть в виде текстового представления числа. Пример: "пять
//плюс четыре" --> "девять".

public class Main_4 {
    public static void main(String[] args) {
        HashMap<String, Integer> numberMap = new HashMap<>();
        numberMap.put("ноль", 0);
        numberMap.put("один", 1);
        numberMap.put("два", 2);
        numberMap.put("три", 3);
        numberMap.put("четыре", 4);
        numberMap.put("пять", 5);
        numberMap.put("шесть", 6);
        numberMap.put("семь", 7);
        numberMap.put("восемь", 8);
        numberMap.put("девять", 9);

        HashMap<Integer, String> reverseNumberMap = new HashMap<>();
        for (String key : numberMap.keySet()) {
            reverseNumberMap.put(numberMap.get(key), key);
        }

        HashMap<String, String> operationMap = new HashMap<>();
        operationMap.put("плюс", "+");
        operationMap.put("минус", "-");
        operationMap.put("умножить", "*");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строковое выражение вида '<число> <операция> <число>':");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Неверный формат ввода. Используйте формат '<число> <операция> <число>'");
            return;
        }

        String word1 = parts[0];
        String operation = parts[1];
        String word2 = parts[2];

        Integer num1 = numberMap.get(word1);
        Integer num2 = numberMap.get(word2);
        String op = operationMap.get(operation);

        if (num1 == null || num2 == null || op == null) {
            System.out.println("Ошибка: введены некорректные данные.");
            return;
        }

        int result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                System.out.println("Неверная операция.");
                return;
        }

        String resultWord = reverseNumberMap.get(result);
        if (resultWord == null) {
            System.out.println("Результат вне диапазона (0-9).");
        } else {
            System.out.println("Результат: " + resultWord);
        }
    }
}
