import java.util.Scanner;

//12. Разработайте программу, которая выводит в консоль все цифры, входящие в
//натуральное число n. К примеру, если дано число 2359, то в консоль выводятся отдельно числа
//2, 3, 5, 9.

public class Main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
