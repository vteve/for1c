package number1759;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countHomogenous("aaaaa"));
    }

    public static int countHomogenous(String s) {
        long answer = 0;
        char prevSymbol = s.charAt(0);
        long counter = 1;
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (i == s.length() - 1) {
                if (prevSymbol == s.charAt(i)) {
                    counter++;
                    answer += counter * (counter + 1) / 2;
                } else {
                    answer += counter * (counter + 1) / 2 + 1;
                }
            } else if (prevSymbol == s.charAt(i)) {
                counter++;
            } else {
                answer += counter * (counter + 1) / 2;
                counter = 1;
            }
            prevSymbol = s.charAt(i);
        }
        return (int) (answer % (Math.pow(10, 9) + 7));
    }
}
