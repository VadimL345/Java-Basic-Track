package lab1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Перевіряємо, чи передані аргументи командного рядка
        if (args.length != 2) {
            System.out.println("Будь ласка, вкажіть розміри матриці як два цілі числа: <кількість рядків> <кількість стовпців>");
            return;
        }

        try {
            // Зчитуємо розміри матриці з аргументів командного рядка
            int rows = Integer.parseInt(args[0]);
            int cols = Integer.parseInt(args[1]);

            // Перевіряємо, чи розміри матриці додатні
            if (rows <= 0 || cols <= 0) {
                System.out.println("Розміри матриці повинні бути додатніми цілими числами.");
                return;
            }

            Random random = new Random();

            // Генеруємо матрицю B з типом елементів long (C7 = 4)
            long[][] B = generateMatrix(rows, cols, random);

            // Транспонуємо матрицю B (C5 = 1)
            long[][] C = transposeMatrix(B);

            // Обчислюємо суму найменших елементів кожного стовпця матриці C (C11 = 0)
            long result = sumOfMinInColumns(C);

            // Виведення результатів
            System.out.println("Матриця B:");
            printMatrix(B);
            System.out.println("Транспонована матриця C:");
            printMatrix(C);
            System.out.println("Сума найменших елементів кожного стовпця матриці C: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Будь ласка, введіть коректні цілі числа для розмірів матриці.");
        }
    }

    // Генерація матриці типу long
    public static long[][] generateMatrix(int rows, int cols, Random random) {
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextLong(100); // Генеруємо числа від 0 до 99
            }
        }
        return matrix;
    }

    // Транспонування матриці
    public static long[][] transposeMatrix(long[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long[][] transposed = new long[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Обчислення суми найменших елементів кожного стовпця
    public static long sumOfMinInColumns(long[][] matrix) {
        int cols = matrix[0].length;
        long sum = 0;

        for (int j = 0; j < cols; j++) {
            long min = Long.MAX_VALUE;
            for (long[] longs : matrix) {
                if (longs[j] < min) {
                    min = longs[j];
                }
            }
            sum += min;
        }

        return sum;
    }

    // Виведення матриці
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long element : row) {
                System.out.printf("%10d ", element);
            }
            System.out.println();
        }
    }
}
