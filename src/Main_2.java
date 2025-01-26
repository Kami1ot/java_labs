import java.util.ArrayList;


public class Main_2 {
    public static void main(String[] args) {
        String input = "I have 3 cats, 4 dogs, and 1 turtle";

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String word : input.split(" ")) {
            try {
                int number = Integer.parseInt(word);
                numbers.add(number);
            } catch (NumberFormatException e) {
            }
        }

        int[] resultArray = numbers.stream().mapToInt(i -> i).toArray();

        System.out.println("Массив чисел:");
        for (int num : resultArray) {
            System.out.print(num + " ");
        }
    }
}
