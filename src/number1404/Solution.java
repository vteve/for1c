package number1404;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numSteps("100001000"));
    }

    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0';
            if (digit + carry == 1) {
                carry = 1;
                steps += 2;
            } else {
                steps += 1;
            }
        }

        if (carry == 1) {
            steps += 1;
        }

        return steps;
    }
}

/////////////лучшее решение
//class Solution {
//    public int numSteps(String s) {
//        int steps = 0;
//        int carry = 0;
//
//        for (int i = s.length() - 1; i > 0; i--) {
//            int digit = s.charAt(i) - '0';
//            if (digit + carry == 1) {
//                carry = 1;
//                steps += 2;
//            } else {
//
//                steps += 1;
//            }
//        }
//
//        if (carry == 1) {
//            steps += 1;
//        }
//
//        return steps;
//    }
//}
