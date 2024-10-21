package number424;

public class Solution {
    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }

    public static int characterReplacement(String s, int k) {
        int[] letters = new int[26];
        int res = 0;
        int max = 0;

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'A']++;

            max = Math.max(max, letters[s.charAt(i) - 'A']);

            if (i - left + 1 - max > k) {
                letters[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
