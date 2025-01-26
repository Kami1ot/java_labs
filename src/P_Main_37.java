// 37. Разработать класс P_Main_37 для реализации нейронной сети из двух нейронов и одного выхода. Сделать функцию прямого распространения с функцией активации в виде сигмоиды.

public class P_Main_37 {
    private final double[] weights;
    private double bias;

    public P_Main_37(int inputSize) {
        weights = new double[inputSize];
        bias = 0;
        initializeWeights();
    }

    private void initializeWeights() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() - 0.5;
        }
        bias = Math.random() - 0.5;
    }

    public double forward(double[] inputs) {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Количество входов должно соответствовать количеству весов.");
        }
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        sum += bias;
        return sigmoid(sum);
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static void main(String[] args) {
        P_Main_37 PMain371 = new P_Main_37(2);
        P_Main_37 PMain372 = new P_Main_37(2);
        P_Main_37 outputPMain37 = new P_Main_37(2);

        double[] inputs = {0.5, 0.8};

        double output1 = PMain371.forward(inputs);
        double output2 = PMain372.forward(inputs);

        double finalOutput = outputPMain37.forward(new double[]{output1, output2});

        System.out.println("Выход первого нейрона: " + output1);
        System.out.println("Выход второго нейрона: " + output2);
        System.out.println("Итоговый выход: " + finalOutput);
    }
}

