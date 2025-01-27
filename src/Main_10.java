import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;



//Написать класс, который при введении даты в формате ДД.ММ.ГГ (к примеру,
//22.10.20) выводит номер недели. Даты начиная с 2020 по 2022 годы. К примеру, первая неделя в
//2020 году: 1-5 января, вторая неделя – 6-12 января. Значит при вводе 08.01.20 вывод должен быть:
//Неделя 2.

public class Main_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате ДД.ММ.ГГ (например, 08.01.20):");
        String inputDate = scanner.nextLine();

        try {
            // Парсим введенную дату
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
            LocalDate date = LocalDate.parse(inputDate, formatter);

            // Проверяем диапазон дат
            if (date.getYear() < 2020 || date.getYear() > 2022) {
                System.out.println("Ошибка: дата должна быть в диапазоне с 2020 по 2022 год.");
                return;
            }

            // Получаем номер недели
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = date.get(weekFields.weekOfYear());

            // Вывод результата
            System.out.println("Неделя " + weekNumber);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: некорректный формат даты. Пожалуйста, используйте формат ДД.ММ.ГГ.");
        }

        scanner.close();
    }
}
