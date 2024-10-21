package number812;

import java.util.Arrays;

public class Solution {
    public static double largestTriangleArea(int[][] points) {
        int[][][] extremePoints = new int[4][2][2];
        extremePoints[0][0][0] = Integer.MAX_VALUE;
        extremePoints[1][1][0] = Integer.MIN_VALUE;
        extremePoints[2][0][0] = Integer.MIN_VALUE;
        extremePoints[3][1][0] = Integer.MAX_VALUE;
        extremePoints[0][0][1] = Integer.MAX_VALUE;
        extremePoints[1][1][1] = Integer.MIN_VALUE;
        extremePoints[2][0][1] = Integer.MIN_VALUE;
        extremePoints[3][1][1] = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= extremePoints[0][0][0] && points[i][1] < extremePoints[0][1][0]) {
                extremePoints[0][0][0] = points[i][0];
                extremePoints[0][1][0] = points[i][1];
            } else if (points[i][0] <= extremePoints[0][0][1] && points[i][1] > extremePoints[0][1][1]) {
                extremePoints[0][0][1] = points[i][0];
                extremePoints[0][1][1] = points[i][1];
            }
            if (points[i][0] >= extremePoints[2][0][0] && points[i][1] < extremePoints[2][1][0]) {
                extremePoints[2][0][0] = points[i][0];
                extremePoints[2][1][0] = points[i][1];
            } else if (points[i][0] >= extremePoints[2][0][1] && points[i][1] < extremePoints[2][1][1]) {
                extremePoints[2][0][1] = points[i][0];
                extremePoints[2][1][1] = points[i][1];
            }
            if (points[i][1] <= extremePoints[3][1][0] && points[i][0] < extremePoints[3][0][0]) {
                extremePoints[3][0][0] = points[i][0];
                extremePoints[3][1][0] = points[i][1];
            } else if (points[i][1] <= extremePoints[3][1][1] && points[i][0] > extremePoints[3][0][1]) {
                extremePoints[3][0][1] = points[i][0];
                extremePoints[3][1][1] = points[i][1];
            }
            if (points[i][1] >= extremePoints[1][1][0] && points[i][0] < extremePoints[1][0][0]) {
                extremePoints[1][0][0] = points[i][0];
                extremePoints[1][1][0] = points[i][1];
            } else if (points[i][1] >= extremePoints[1][1][1] && points[i][0] > extremePoints[1][0][1]) {
                extremePoints[1][0][1] = points[i][0];
                extremePoints[1][1][1] = points[i][1];
            }
        }
        double[] anss = new double[12];
        if (pr(extremePoints[1][0][0], extremePoints[0][0][1], extremePoints[2][1][0], extremePoints[0][1][1], extremePoints[2][0][0], extremePoints[1][1][0])) {
            anss[0] = Math.abs((extremePoints[1][0][0] - extremePoints[0][0][1]) * (extremePoints[2][1][0] - extremePoints[0][1][1]) - (extremePoints[2][0][0] - extremePoints[0][0][1]) * (extremePoints[1][1][0] - extremePoints[0][1][1]));
        } else {
            anss[0] = -1;
        }
        if (pr(extremePoints[1][0][1], extremePoints[0][0][0], extremePoints[2][1][0], extremePoints[0][1][0], extremePoints[2][0][0], extremePoints[1][1][1])) {
            anss[1] = Math.abs((extremePoints[1][0][1] - extremePoints[0][0][0]) * (extremePoints[2][1][0] - extremePoints[0][1][0]) - (extremePoints[2][0][0] - extremePoints[0][0][0]) * (extremePoints[1][1][1] - extremePoints[0][1][0]));
        } else {
            anss[1] = -1;
        }
        if (pr(extremePoints[1][0][0], extremePoints[0][0][0], extremePoints[2][1][1], extremePoints[0][1][0], extremePoints[2][0][1], extremePoints[1][1][0])) {
            anss[2] = Math.abs((extremePoints[1][0][0] - extremePoints[0][0][0]) * (extremePoints[2][1][1] - extremePoints[0][1][0]) - (extremePoints[2][0][1] - extremePoints[0][0][0]) * (extremePoints[1][1][0] - extremePoints[0][1][0]));
        } else {
            anss[2] = -1;
        }
        if (pr(extremePoints[2][0][0], extremePoints[1][0][1], extremePoints[3][1][0], extremePoints[1][1][1], extremePoints[3][0][0], extremePoints[2][1][0])) {
            anss[3] = Math.abs((extremePoints[2][0][0] - extremePoints[1][0][1]) * (extremePoints[3][1][0] - extremePoints[1][1][1]) - (extremePoints[3][0][0] - extremePoints[1][0][1]) * (extremePoints[2][1][0] - extremePoints[1][1][1]));
        } else {
            anss[3] = -1;
        }
        if (pr(extremePoints[2][0][1], extremePoints[1][0][0], extremePoints[3][1][0], extremePoints[1][1][0], extremePoints[3][0][0], extremePoints[2][1][1])) {
            anss[4] = Math.abs((extremePoints[2][0][1] - extremePoints[1][0][0]) * (extremePoints[3][1][0] - extremePoints[1][1][0]) - (extremePoints[3][0][0] - extremePoints[1][0][0]) * (extremePoints[2][1][1] - extremePoints[1][1][0]));
        } else {
            anss[4] = -1;
        }
        if (pr(extremePoints[2][0][0], extremePoints[1][0][0], extremePoints[3][1][1], extremePoints[1][1][0], extremePoints[3][0][1], extremePoints[2][1][0])) {
            anss[5] = Math.abs((extremePoints[2][0][0] - extremePoints[1][0][0]) * (extremePoints[3][1][1] - extremePoints[1][1][0]) - (extremePoints[3][0][1] - extremePoints[1][0][0]) * (extremePoints[2][1][0] - extremePoints[1][1][0]));
        } else {
            anss[5] = -1;
        }
        if (pr(extremePoints[3][0][0], extremePoints[2][0][1], extremePoints[0][1][0], extremePoints[2][1][1], extremePoints[0][0][0], extremePoints[3][1][0])) {
            anss[6] = Math.abs((extremePoints[3][0][0] - extremePoints[2][0][1]) * (extremePoints[0][1][0] - extremePoints[2][1][1]) - (extremePoints[0][0][0] - extremePoints[2][0][1]) * (extremePoints[3][1][0] - extremePoints[2][1][1]));
        } else {
            anss[6] = -1;
        }
        if (pr(extremePoints[3][0][1], extremePoints[2][0][0], extremePoints[0][1][0], extremePoints[2][1][0], extremePoints[0][0][0], extremePoints[3][1][1])) {
            anss[7] = Math.abs((extremePoints[3][0][1] - extremePoints[2][0][0]) * (extremePoints[0][1][0] - extremePoints[2][1][0]) - (extremePoints[0][0][0] - extremePoints[2][0][0]) * (extremePoints[3][1][1] - extremePoints[2][1][0]));
        } else {
            anss[7] = -1;
        }
        if (pr(extremePoints[3][0][0], extremePoints[2][0][0], extremePoints[0][1][1], extremePoints[2][1][0], extremePoints[0][0][1], extremePoints[3][1][0])) {
            anss[8] = Math.abs((extremePoints[3][0][0] - extremePoints[2][0][0]) * (extremePoints[0][1][1] - extremePoints[2][1][0]) - (extremePoints[0][0][1] - extremePoints[2][0][0]) * (extremePoints[3][1][0] - extremePoints[2][1][0]));
        } else {
            anss[8] = -1;
        }
        if (pr(extremePoints[0][0][0], extremePoints[3][0][1], extremePoints[1][1][0], extremePoints[3][1][1], extremePoints[1][0][0], extremePoints[0][1][0])) {
            anss[9] = Math.abs((extremePoints[0][0][0] - extremePoints[3][0][1]) * (extremePoints[1][1][0] - extremePoints[3][1][1]) - (extremePoints[1][0][0] - extremePoints[3][0][1]) * (extremePoints[0][1][0] - extremePoints[3][1][1]));
        } else {
            anss[9] = -1;
        }
        if (pr(extremePoints[0][0][1], extremePoints[3][0][0], extremePoints[1][1][0], extremePoints[3][1][0], extremePoints[1][0][0], extremePoints[0][1][1])) {
            anss[10] = Math.abs((extremePoints[0][0][1] - extremePoints[3][0][0]) * (extremePoints[1][1][0] - extremePoints[3][1][0]) - (extremePoints[1][0][0] - extremePoints[3][0][0]) * (extremePoints[0][1][1] - extremePoints[3][1][0]));
        } else {
            anss[10] = -1;
        }
        if (pr(extremePoints[0][0][0], extremePoints[3][0][0], extremePoints[1][1][1], extremePoints[3][1][0], extremePoints[1][0][1], extremePoints[0][1][0])) {
            anss[11] = Math.abs((extremePoints[0][0][0] - extremePoints[3][0][0]) * (extremePoints[1][1][1] - extremePoints[3][1][0]) - (extremePoints[1][0][1] - extremePoints[3][0][0]) * (extremePoints[0][1][0] - extremePoints[3][1][0]));
        } else {
            anss[11] = -1;
        }
        return Arrays.stream(anss).max().getAsDouble() / 2;
    }

    public static boolean pr(int a, int b, int c, int d, int e, int f) {
        if (a == Integer.MAX_VALUE || a == Integer.MIN_VALUE) {
            return false;
        }
        if (b == Integer.MAX_VALUE || b == Integer.MIN_VALUE) {
            return false;
        }
        if (c == Integer.MAX_VALUE || c == Integer.MIN_VALUE) {
            return false;
        }
        if (d == Integer.MAX_VALUE || d == Integer.MIN_VALUE) {
            return false;
        }
        if (e == Integer.MAX_VALUE || e == Integer.MIN_VALUE) {
            return false;
        }
        if (f == Integer.MAX_VALUE || f == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{10, 7}, {0, 4}, {5, 7}}));
    }
}
