// 27. Создать класс P_Main_27 для работы с двоичными числами фиксированной длины. Число должно быть массивом тип char, каждый элемент которого принимает значение 0 или 1.
//Младший бит имеет младший индекс. Отрицательные числа представляются в дополнительном коде. Дополнительный код получается инверсией всех битов с прибавлением 1 к младшему биту.
// Например, +1 – это в двоичном коде будет выглядеть, как 0000 0001. А -1 в двоичном коде будет выглядеть, как 1111 1110 + 0000 0001 = 1111 1111.
// Создать методы конвертации десятичного числа в массив и обратно.

import java.util.Arrays;

public class P_Main_27 {
    private final char[] bits; // Массив символов для хранения двоичного числа

    // Конструктор: принимает длину массива
    public P_Main_27(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина должна быть положительным числом.");
        }
        bits = new char[length];
        Arrays.fill(bits, '0'); // Инициализируем массив нулями
    }

    // Метод для конвертации десятичного числа в двоичное представление
    public void fromDecimal(int number) {
        boolean isNegative = number < 0; // Определяем, является ли число отрицательным
        int absNumber = Math.abs(number);

        // Переводим абсолютное значение числа в двоичное представление
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (char) ((absNumber % 2) + '0');
            absNumber /= 2;
        }

        if (isNegative) {
            toTwosComplement(); // Преобразуем в дополнительный код для отрицательных чисел
        }
    }

    // Метод для конвертации двоичного числа обратно в десятичное
    public int toDecimal() {
        boolean isNegative = bits[bits.length - 1] == '1'; // Если старший бит равен 1, число отрицательное

        char[] workingBits = Arrays.copyOf(bits, bits.length);

        // Если число отрицательное, преобразуем из дополнительного кода в прямой
        if (isNegative) {
            fromTwosComplement(workingBits);
        }

        int decimal = 0;
        for (int i = 0; i < workingBits.length; i++) {
            decimal += (int) ((workingBits[i] - '0') * Math.pow(2, i));
        }

        return isNegative ? -decimal : decimal;
    }

    // Метод для преобразования в дополнительный код
    private void toTwosComplement() {
        // Инвертируем все биты
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] == '0') ? '1' : '0';
        }

        // Прибавляем 1 к младшему биту
        int carry = 1;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1' && carry == 1) {
                bits[i] = '0';
            } else if (carry == 1) {
                bits[i] = '1';
                carry = 0;
            }
        }
    }

    // Метод для преобразования из дополнительного кода в прямой
    private void fromTwosComplement(char[] bits) {
        // Инвертируем все биты
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] == '0') ? '1' : '0';
        }

        // Прибавляем 1 к младшему биту
        int carry = 1;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '1' && carry == 1) {
                bits[i] = '0';
            } else if (carry == 1) {
                bits[i] = '1';
                carry = 0;
            }
        }
    }

    // Переопределение метода toString для вывода двоичного числа
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = bits.length - 1; i >= 0; i--) { // Выводим в порядке от старших битов к младшим
            builder.append(bits[i]);
        }
        return builder.toString();
    }

    // Тестирование
    public static void main(String[] args) {
        P_Main_27 PMain27 = new P_Main_27(8); // Создаем двоичное число длиной 8 бит

        // Пример: перевод +1
        PMain27.fromDecimal(1);
        System.out.println("+1 в двоичном: " + PMain27);
        System.out.println("Обратно в десятичное: " + PMain27.toDecimal());

        // Пример: перевод -1
        PMain27.fromDecimal(-1);
        System.out.println("-1 в двоичном: " + PMain27);
        System.out.println("Обратно в десятичное: " + PMain27.toDecimal());

        // Пример: перевод +127
        PMain27.fromDecimal(127);
        System.out.println("+127 в двоичном: " + PMain27);
        System.out.println("Обратно в десятичное: " + PMain27.toDecimal());

        // Пример: перевод -128
        PMain27.fromDecimal(-128);
        System.out.println("-128 в двоичном: " + PMain27);
        System.out.println("Обратно в десятичное: " + PMain27.toDecimal());
    }
}

