// 40. На основе класса BitSet разработайте программу для реализации битовых операций AND, OR, XOR, а также маскирования.

import java.util.BitSet;
import java.util.Scanner;

public class P_Main_40 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер битового набора: ");
        int size = scanner.nextInt();

        BitSet bitSet1 = new BitSet(size);
        BitSet bitSet2 = new BitSet(size);

        System.out.println("Установите биты для первого набора:");
        setBits(bitSet1, scanner);

        System.out.println("Установите биты для второго набора:");
        setBits(bitSet2, scanner);

        System.out.println("Первый набор битов: " + toBinaryString(bitSet1, size));
        System.out.println("Второй набор битов: " + toBinaryString(bitSet2, size));

        BitSet andResult = (BitSet) bitSet1.clone();
        andResult.and(bitSet2);
        System.out.println("Результат AND: " + toBinaryString(andResult, size));

        BitSet orResult = (BitSet) bitSet1.clone();
        orResult.or(bitSet2);
        System.out.println("Результат OR: " + toBinaryString(orResult, size));

        BitSet xorResult = (BitSet) bitSet1.clone();
        xorResult.xor(bitSet2);
        System.out.println("Результат XOR: " + toBinaryString(xorResult, size));

        System.out.println("Введите маску для применения:");
        BitSet mask = new BitSet(size);
        setBits(mask, scanner);

        BitSet maskedResult = (BitSet) bitSet1.clone();
        maskedResult.and(mask);
        System.out.println("Результат маскирования первого набора: " + toBinaryString(maskedResult, size));
    }

    private static void setBits(BitSet bitSet, Scanner scanner) {
        System.out.print("Введите номера битов (через пробел), которые нужно установить (или -1 для завершения): ");
        while (true) {
            int bit = scanner.nextInt();
            if (bit == -1) {
                break;
            }
            bitSet.set(bit);
        }
    }

    private static String toBinaryString(BitSet bitSet, int size) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            binaryString.append(bitSet.get(i) ? "1" : "0");
        }
        return binaryString.toString();
    }
}
