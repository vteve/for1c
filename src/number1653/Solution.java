package number1653;

public class Solution {
    public static int minimumDeletions(String s) {
        if (!s.contains("a") || !s.contains("b")) {
            return 0;
        }

        int countA = 0, countB = 0, tempA = 0;
        int a = 0, b = 0, diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a++;
            } else {
                b++;
            }
            if (diff < a - b) {
                diff = a - b;
                countB = b;
                tempA = a;
            }
        }
        countA = a - tempA;

        return countB + countA;
    }
}
