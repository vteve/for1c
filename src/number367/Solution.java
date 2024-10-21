package number367;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(107));
    }

    public static double mySqrt(double d) {
        double t = d;
        int counter = 0;
        while ((t > d / t)) {
            t = (d / t + t) / 2.0;
            counter++;
            if (counter > 100) {
                return t;
            }
        }

        return t;
    }

    public static boolean isPerfectSquare(int num) {
        return mySqrt(num) == (int) mySqrt(num);
    }
}
