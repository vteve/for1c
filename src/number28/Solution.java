package number28;

public class Solution {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        int indexOfNeedle = 0, answer = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(indexOfNeedle)) {
                indexOfNeedle++;
                if (indexOfNeedle == needle.length()) {
                    answer = i - indexOfNeedle + 1;
                    break;
                }
            } else {
                i = i - indexOfNeedle;
                indexOfNeedle = 0;
            }
        }
        return answer;
    }
}
