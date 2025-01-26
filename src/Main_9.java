import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате dd.MM.yyyy (например, 13.02.2005):");
        String inputDate = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            DayOfWeek dayOfWeek = date.getDayOfWeek();

            System.out.println("День недели: " + dayOfWeek);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: введена некорректная дата. Пожалуйста, используйте формат dd.MM.yyyy.");
        }

        scanner.close();
    }
}
