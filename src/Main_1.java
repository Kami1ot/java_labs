import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

//1. Условие: «Реализовать программу для выполнения следующих математических
//операций с целочисленным, байтовым и вещественным типами данных: сложение, вычитание,
//умножение, деление, деление по модулю (остаток), модуль числа, возведение в степень. Все
//данные вводятся с клавиатуры (класс Scanner, System.in, nextint).» По данному условию
//необходимо реализовать программу с интерактивным консольным меню, (т.е. вывод списка
//действий по цифрам. При этом при нажатии на цифру у нас должно выполняться определенное
//действие). При этом в программе данные пункты должны называться следующим образом:
//        1. Вывести все таблицы из MySQL.
//2. Создать таблицу в MySQL.
//        3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль.
//        4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль.
//        5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.
//        6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.
//        7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим
//выводом в консоль.
//8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом в
//консоль.
//9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом в
//консоль.
//10. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на
//экран.


public class Main_1 {
    public static void main(String[] args) throws SQLException, IOException {
        Helper help = new Helper();
        help.Connection("jdbc:mysql://localhost/test", "root", "ensoxPER324");
        Scanner in = new Scanner(System.in);
        String tablename = "oper";
        String sql = "CREATE TABLE IF NOT EXISTS `test`.`" + tablename + "` (\n" +
                "  `num1` FLOAT NULL,\n" +
                "  `operation` VARCHAR(45) NULL,\n" +
                "  `num2` FLOAT NULL,\n" +
                "  `result` FLOAT NULL,\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  PRIMARY KEY (`id`));";
        help.execute_Update(sql);
        int input;
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("1 - вывод таблиц");
            System.out.println("2 - создание таблицы");
            System.out.println("3 - Excel");
            System.out.println("4 - Операции");
            System.out.println("5 - выход");
            System.out.println("--------------------------------------------------");
            System.out.print("Введите операцию: ");
            while (!in.hasNextInt()) {
                System.out.print("Ошибка! Введите корректное число: ");
                in.next();
            }
            input = in.nextInt();
            if (input == 5) {

                break;
            }
            if (input > 5) {
                System.out.println("Неверный ввод числа!");
                continue;
            }
            switch (input) {
                case (1):
                    help.show_table();
                    break;
                case (2):
                    help.create_table();
                    break;
                case (3):
                    help.to_excel("oper", "output.xlsx");
                    break;
                case (4):
                    //            вычисление
                    while (true) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("1. Сложение");
                        System.out.println("2. Вычитание");
                        System.out.println("3. Умножение");
                        System.out.println("4. Деление");
                        System.out.println("5. Деление чисел по модулю");
                        System.out.println("6. Возведение числа в степень");
                        System.out.println("7. Возведение числа в модуль");
                        System.out.println("8. Выйти");
                        System.out.println("--------------------------------------------------");
                        System.out.print("Введите операцию: ");
                        while (!in.hasNextInt()) {
                            System.out.print("Ошибка! Введите корректное число: ");
                            in.next();
                        }
                        input = in.nextInt();
                        if (input > 8) {
                            System.out.println("Неверный ввод числа!");
                            continue;
                        }
                        if (input == 8) break;
                        float input1, input2;
                        float end;
                        System.out.print("Введите число: ");
                        while (!in.hasNextInt()) {
                            System.out.print("Ошибка! Введите корректное число: ");
                            in.next();
                        }
                        input1 = (float) in.nextInt();
                        if (input == 7) {
                            end = (Math.abs(input1));

                            simple_func(input1, 0.0f, "abs", end, tablename, help);

                        } else {
                            System.out.print("Введите второе число: ");
                            while (!in.hasNextInt()) {
                                System.out.print("Ошибка! Введите корректное число: ");
                                in.next();
                            }
                            input2 = (float) in.nextInt();
                            switch (input) {
                                case (1):
                                    end = input1 + input2;
                                    simple_func(input1, input2, "+", end, tablename, help);
                                    break;
                                case (2):
                                    end = input1 - input2;
                                    simple_func(input1, input2, "-", end, tablename, help);

                                    break;
                                case (3):
                                    end = input1 * input2;
                                    simple_func(input1, input2, "*", end, tablename, help);
                                    break;
                                case (4):
                                    end = input1 / input2;
                                    simple_func(input1, input2, "/", end, tablename, help);
                                    break;
                                case (5):
                                    end = input1 % input2;
                                    simple_func(input1, input2, "%", end, tablename, help);
                                    break;
                                case (6):
                                    end = (float) Math.pow(input1, input2);
                                    simple_func(input1, input2, "pow", end, tablename, help);
                                    break;
                            }
                        }
                    }
                    break;
            }
        }
    }
    private static void simple_func(float input1, float input2, String  operation, float result, String tablename, Helper help) throws SQLException {
        System.out.println("--------------------------------------------------");
        System.out.println("Ответ равен: " + result);

        PreparedStatement stmt = help.con.prepareStatement("INSERT INTO " + tablename + " (num1, operation, num2, result) VALUES (?, ?, ?, ?)");
        stmt.setFloat(1, input1);
        stmt.setString(2, operation);
        stmt.setFloat(3, input2);
        stmt.setFloat(4, result);
        stmt.executeUpdate();
    }
}




