//26. Разработать интерфейс InArray, в котором предусмотреть метод сложения двух массивов. Создать класс ArraySum, в котором имплементируется метод сложения массивов.
// Создать класс OrArray, в котором метод сложения массивов имплементируется как логическая операция ИЛИ между элементами массива.

interface InArray {
    // Метод сложения двух массивов
    int[] combineArrays(int[] array1, int[] array2);
}

class ArraySum implements InArray {

    @Override
    public int[] combineArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Массивы должны быть одинаковой длины");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] + array2[i];
        }
        return result;
    }
}

class OrArray implements InArray {

    @Override
    public int[] combineArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Массивы должны быть одинаковой длины");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] | array2[i];
        }
        return result;
    }
}

public class P_Main_26 {
    public static void main(String[] args) {
        int[] array1 = {12, 2, 3, 4};
        int[] array2 = {4, 3, 2, 1};

        InArray arraySum = new ArraySum();
        int[] sumResult = arraySum.combineArrays(array1, array2);
        System.out.println("Результат сложения массивов:");
        printArray(sumResult);

        InArray orArray = new OrArray();
        int[] orResult = orArray.combineArrays(array1, array2);
        System.out.println("Результат логической операции ИЛИ:");
        printArray(orResult);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
