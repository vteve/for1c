package number50;

class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(2.0000, 10));
    }

    public static double myPow(double x, int n) {
        double ans = 1;
        long nTemporary = n;
        if (nTemporary < 0) {
            nTemporary *= -1;
        }
        final int[] arrayOfSimpleNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        while (nTemporary > 0) {
            boolean flag = true;
            for (int element : arrayOfSimpleNumbers) {
                if (nTemporary % element == 0) {
                    double a = x;
                    for (int i = 0; i < element - 1; i++) {
                        x = x * a;
                    }
                    nTemporary = nTemporary / element;
                    flag = false;
                }
            }
            if (flag) {
                ans = ans * x;
                nTemporary--;
            }
        }
        if (n < 0) {
            return (double) 1 / ans;
        }
        return ans;
    }
}

//class Solution1 {
//    public static void main(String[] args) {
//        System.out.println(myPow(2.0000, -2147483648));
//    }
//
//    public static double myPow(double x, int n) {
//        double ans = 1;
//        long n_temp = n;
//        if (n_temp < 0) {
//            n_temp *= -1;
//        }
//        while (n_temp > 0) {
//            if (n_temp % 2 == 0) {
//                x = x * x;
//                n_temp = n_temp / 2;
//            } else {
//                ans = ans * x;
//                n_temp--;
//            }
//        }
//        if (n < 0) {
//            return (double) 1 / ans;
//        }
//        return ans;
//    }
//}