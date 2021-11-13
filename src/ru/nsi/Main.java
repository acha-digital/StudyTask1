package ru.nsi;

public class Main {

    private static int[] generateSequence(int begin, int end, int count) {
        int[] sequence = new int[count];

        for (int i = 0; i<count; i++) {
            sequence[i] = (int) (Math.random()*(end-begin)+begin);
        }

        return sequence;
    }

    private static int getMinValue(int[] sequence) {
        int minValue = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (minValue > sequence[i]) minValue = sequence[i];
        }

        return minValue;
    }

    private static int getMaxValue(int[] sequence) {
        int maxValue = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (maxValue < sequence[i]) maxValue = sequence[i];
        }
        return maxValue;
    }

    private static double getAvgValue(int[] sequence) {
        double avgValue = sequence[0];
        int summ = sequence[0];

        for (int i = 1; i<sequence.length; i--) {
            summ = summ + sequence[i];
        }

        avgValue = (double) summ / (double) sequence.length;

        return avgValue;
    }

    public static void main(String[] args) {
        //1. Считать аргументы командной строки
        int begin = Integer.parseInt( args[0] );
        int end = Integer.parseInt( args[1] );
        int count = Integer.parseInt( args[2] );

        System.out.println( String.format("BEGIN: %s, END: %s, COUNT: %s", begin, end, count) );

        //2. Сгенерировать и вывести последовательность в одну строчку, разделяя элементы пробелом
        int[] sequence = generateSequence(begin, end, count);

        for (int i = 0; i<sequence.length; i++) System.out.print(sequence[i] + " ");

        System.out.println("");

        //3. Вывести в одну строчку минимальное, максимальное и средние значения последовательности
        System.out.println( String.format("MIN: %s MAX: %s AVG: %s", getMinValue(sequence), getMaxValue(sequence), getAvgValue(sequence)) );
    }
}
