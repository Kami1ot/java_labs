// 30. Разработать программу для игры «Угадайка». Программа загадывает случайное число от 1 до 10, требуется его отгадать с трех попыток.
// После каждой попытки, если результат неверен, игроку выводится сообщение, меньше или больше названное игроком число, чем загаданное.
// Сет заканчивается или если игрок угадывает число, или если исчерпывает три попытки, не угадав. Игра должна быть выполнена в бесконечном цикле,
// и продолжается до тех пор, пока на предложение «Сыграем еще раз?» игрок не напишет «Нет».


import java.util.Random;
import java.util.Scanner;

public class P_Main_30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int secretNumber = random.nextInt(10) + 1;
            boolean guessed = false;

            System.out.println("Я загадал число от 1 до 10. У тебя есть три попытки, чтобы его угадать.");

            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.print("Попытка " + attempt + ": ");
                int playerGuess = scanner.nextInt();

                if (playerGuess == secretNumber) {
                    System.out.println("Поздравляю! Ты угадал число.");
                    guessed = true;
                    break;
                } else if (playerGuess < secretNumber) {
                    System.out.println("Загаданное число больше.");
                } else {
                    System.out.println("Загаданное число меньше.");
                }
            }

            if (!guessed) {
                System.out.println("Ты не угадал! Загаданное число было: " + secretNumber);
            }

            System.out.print("Сыграем еще раз? (Да/Нет): ");
            scanner.nextLine();
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Нет")) {
                System.out.println("Спасибо за игру!");
                break;
            }
        }

        scanner.close();
    }
}
