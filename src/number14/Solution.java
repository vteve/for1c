package number14;

public class Solution {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"abab", "aba", ""});
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (answer.length() == 0) {
                break;
            }
            int lenthOfString = Math.min(strs[i].length(), answer.length());
            if (lenthOfString == 0) {
                return "";
            }
            for (int j = 0; j < lenthOfString; j++) {
                if (strs[i].charAt(j) != answer.charAt(j)) {
                    answer.setLength(j);
                    break;
                } else if (strs[i].length() < answer.length()) {
                    answer.setLength(strs[i].length());
                    lenthOfString = strs[i].length();
//                    break;
                }
            }
        }
        return answer.toString();
    }
}
