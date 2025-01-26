// 49. Напишите программу, которая каждые 5 секунд отображает на экране данные о времени, прошедшем от начала запуска программы,
// а другой её поток выводит сообщение каждые 7 секунд. Третий поток выводит на экран сообщение каждые 10 секунд. Программа работает одну минуту, затем останавливается.
// Все результаты после вывода необходимо сохранить в MySQL/PostgreSQL.

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class P_Main_49 {

    public static void main(String[] args) throws Exception {
        Helper dbHelper = new Helper();
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        dbHelper.Connection(url, user, password);

        String tableName = "TimerLogs";
        dbHelper.execute_Update("CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "message TEXT, " +
                "timestamp TIME)");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();

        Runnable task1 = () -> {
            while (System.currentTimeMillis() - startTime < 60000) {
                logMessage(dbHelper, tableName, "Прошло 5 секунд");
                sleep(5000);
            }
        };

        Runnable task2 = () -> {
            while (System.currentTimeMillis() - startTime < 60000) {
                logMessage(dbHelper, tableName, "Прошло 7 секунд");
                sleep(7000);
            }
        };

        Runnable task3 = () -> {
            while (System.currentTimeMillis() - startTime < 60000) {
                logMessage(dbHelper, tableName, "Прошло 10 секунд");
                sleep(10000);
            }
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(1000);
        }

        System.out.println("Программа завершила работу. Содержимое базы данных:");
        dbHelper.rs_to_console("SELECT * FROM " + tableName);
    }

    private static void logMessage(Helper dbHelper, String tableName, String message) {
        String currentTime = LocalTime.now().toString();
        System.out.println(message + " | Время: " + currentTime);
        try {
            dbHelper.execute_Update("INSERT INTO " + tableName + " (message, timestamp) VALUES ('" + message + "', '" + currentTime + "')");
        } catch (Exception e) {
            System.err.println("Ошибка при сохранении в базу данных: " + e.getMessage());
        }
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
