package number1514;


public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = succProb[i];
            matrix[edges[i][1]][edges[i][0]] = succProb[i];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] < matrix[i][k] * matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] * matrix[k][j];
                    }
                }
            }
        }
        return matrix[start_node][end_node];
    }
}
