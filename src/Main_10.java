import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

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
