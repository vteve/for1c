package turnMatrix;

public class TurnMatrix {
    public static void main(String[] args) {
        // исходные данные
        int m = 4, n = 3;
        int[][] matrix = {{11, 12, 13}, {14, 15, 16}, {17, 18, 19}, {20, 21, 22}};
        // поворачиваем матрицу и выводим результат
        outputMatrix("Исходная матрица:", matrix);
        outputMatrix("По часовой стрелке ↻:", rotateMatrix(m, n, true, matrix));
        outputMatrix("Против часовой стрелки ↺:", rotateMatrix(m, n, false, matrix));
    }

    public static void outputMatrix(String title, int[][] matrix) {
        System.out.println(title);
        for (int[] row : matrix) {
            for (int el : row)
                System.out.print(" " + el);
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int m, int n, boolean clock, int[][] matrix) {
        // новая матрица, количества строк и колонок меняются местами
        int[][] rotated = new int[n][m];
        // обходим строки исходной матрицы
        for (int i = 0; i < m; i++)
            // обходим колонки исходной матрицы
            for (int j = 0; j < n; j++)
                if (clock) // поворот по часовой стрелке ↻
                    rotated[j][i] = matrix[m - i - 1][j];
                else // поворот против часовой стрелки ↺
                    rotated[j][i] = matrix[i][n - j - 1];
        return rotated;
    }
}
