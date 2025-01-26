// 31. Разработайте программу-генератор рабочего календаря. Слесарь механосборочного цеха работает сутки через трое. Если смена попадает на воскресенье,
// то переносится на понедельник. По введенной дате программа должна генерировать расписание из дат на текущий месяц на 2022 год.

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class P_Main_31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.print("Введите дату начала (в формате dd.MM.yyyy): ");
        String inputDate = scanner.nextLine();

        LocalDate startDate;
        try {
            startDate = LocalDate.parse(inputDate, dateFormatter);
        } catch (Exception e) {
            System.out.println("Некорректный формат даты.");
            return;
        }

        if (startDate.getYear() != 2022) {
            System.out.println("Год должен быть 2022.");
            return;
        }

        LocalDate firstDayOfMonth = startDate.withDayOfMonth(1);
        LocalDate lastDayOfMonth = startDate.withDayOfMonth(startDate.lengthOfMonth());

        System.out.println("Расписание рабочего графика на " +
                firstDayOfMonth.getMonth() + " " + firstDayOfMonth.getYear() + ":");

        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(lastDayOfMonth)) {
            if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                currentDate = currentDate.plusDays(1);
            }
            if (currentDate.getMonth() == firstDayOfMonth.getMonth()) {
                System.out.println(currentDate.format(dateFormatter));
            }
            currentDate = currentDate.plusDays(4);
        }
    }
}
