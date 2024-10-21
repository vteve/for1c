package number344;

public class Solution {
    public void reverseString(char[] s) {
        char symbol = ' ';
        for (int i = 0; i < s.length / 2; i++) {
            symbol = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = symbol;
        }
    }
}
