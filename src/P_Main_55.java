//55. Разработать приложение для работы с локальной базой данных MySQL. Создайте базу данных мобильных телефонов (не менее 10 позиций), со следующими полями: производитель,
//модель, год выпуска, диагональ экрана. Напишите методы для выполнения запросов к базе данных. Все данные должны выводиться в консоли на экран.

import java.util.Scanner;

public class P_Main_55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Инициализация Helper
        Helper dbHelper = new Helper();
        dbHelper.Connection("jdbc:mysql://localhost:3306/mobile_store", "root", "root");

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все телефоны");
            System.out.println("2. Добавить новый телефон");
            System.out.println("3. Удалить телефон по ID");
            System.out.println("4. Найти телефоны по производителю");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showAllPhones(dbHelper);
                case 2 -> addPhone(dbHelper, scanner);
                case 3 -> deletePhoneById(dbHelper, scanner);
                case 4 -> findPhonesByManufacturer(dbHelper, scanner);
                case 5 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void showAllPhones(Helper dbHelper) {
        String query = "SELECT * FROM phones";
        try {
            dbHelper.rs_to_console(query);
        } catch (Exception e) {
            System.out.println("Ошибка при выводе телефонов: " + e.getMessage());
        }
    }

    private static void addPhone(Helper dbHelper, Scanner scanner) {
        System.out.print("Производитель: ");
        String manufacturer = scanner.next();
        System.out.print("Модель: ");
        String model = scanner.next();
        System.out.print("Год выпуска: ");
        int year = scanner.nextInt();
        System.out.print("Диагональ экрана: ");
        double screenSize = scanner.nextDouble();

        String query = "INSERT INTO phones (manufacturer, model, year, screen_size) VALUES ('"
                + manufacturer + "', '" + model + "', " + year + ", " + screenSize + ")";
        try {
            dbHelper.execute_Update(query);
            System.out.println("Телефон успешно добавлен.");
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении телефона: " + e.getMessage());
        }
    }

    private static void deletePhoneById(Helper dbHelper, Scanner scanner) {
        System.out.print("Введите ID телефона для удаления: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM phones WHERE id = " + id;
        try {
            dbHelper.execute_Update(query);
            System.out.println("Телефон успешно удалён.");
        } catch (Exception e) {
            System.out.println("Ошибка при удалении телефона: " + e.getMessage());
        }
    }

    private static void findPhonesByManufacturer(Helper dbHelper, Scanner scanner) {
        System.out.print("Введите производителя: ");
        String manufacturer = scanner.next();

        String query = "SELECT * FROM phones WHERE manufacturer LIKE '%" + manufacturer + "%'";
        try {
            dbHelper.rs_to_console(query);
        } catch (Exception e) {
            System.out.println("Ошибка при поиске телефонов: " + e.getMessage());
        }
    }
}
