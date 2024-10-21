package number125;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder string = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        for (char i = 'a'; i <= 'z'; i++) {
            set.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            set.add(i);
        }

        for (int i = 0; i < string.length(); i++) {
            if (!set.contains(string.charAt(i))) {
                string.deleteCharAt(i);
                i--;
            }
        }

        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
