// 33. Создайте класс Form - оболочку для создания и ввода пароля. Он должен иметь методы input, submit, password.
// Создайте класс SmartForm, который будет наследовать от Form и сохранять значения password.

import java.util.Scanner;

class Form {
    private String password;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        this.password = scanner.nextLine();
    }

    public void submit() {
        if (password == null || password.isEmpty()) {
            System.out.println("Пароль не установлен. Введите пароль перед отправкой.");
        } else {
            System.out.println("Пароль успешно отправлен.");
        }
    }

    public String password() {
        return password;
    }
}

class SmartForm extends Form {
    private String savedPassword;

    @Override
    public void submit() {
        if (password() == null || password().isEmpty()) {
            System.out.println("Пароль не установлен. Введите пароль перед отправкой.");
        } else {
            this.savedPassword = password();
            System.out.println("Пароль успешно сохранен и отправлен.");
        }
    }

    public String getSavedPassword() {
        return savedPassword;
    }
}

public class P_Main_33 {
    public static void main(String[] args) {
        SmartForm smartForm = new SmartForm();

        smartForm.input();
        smartForm.submit();

        System.out.println("Сохраненный пароль: " + smartForm.getSavedPassword());
    }
}

