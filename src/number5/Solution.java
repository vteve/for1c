package number5;

//public class Solution {
//    static int begin = 0;
//    static int end = 0;
//
//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("tattarrattat"));
//    }
//
//    public static String longestPalindrome(String s) {
//        if (s == null) {
//            return "";
//        }
//        char[] chArray = s.toCharArray();
//        getPalindrome(chArray, 0);
//        return s.substring(begin, end + 1);
//    }
//
//    private static void getPalindrome(char[] chArray, int index) {
//        int low = index, high = index, length = chArray.length;
//
//        if (index > length) {
//            return;
//        }
//        while (high < length - 1 && chArray[high] == chArray[high + 1]) {
//            high++;
//        }
//        index = high;
//
//        while (low - 1 >= 0 && high + 1 <= length - 1 && chArray[low - 1] == chArray[high + 1]) {
//            low--;
//            high++;
//        }
//
//        if (end - begin < high - low) {
//            begin = low;
//            end = high;
//        }
//
//        getPalindrome(chArray, index + 1);
//
//    }
//}
public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("sooos"));
    }

    public static String longestPalindrome(String s) {
        int indexMinus = 0, indexPlus = 0;
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            String tmpAnswer = "";
            indexPlus = 0;
            indexMinus = 0;
            while (i + indexPlus < s.length() && isPalindrome(s, i, i + indexPlus)) {
                tmpAnswer = s.substring(i, i + indexPlus + 1);
                indexPlus++;
            }
            if (tmpAnswer.length() > answer.length()) {
                answer = tmpAnswer;
            }
            if (tmpAnswer.length() % 2 == 0) {
                int tmpLength = tmpAnswer.length();
                indexPlus = 0;
                while (i - indexMinus >= 0 && i + tmpLength + indexPlus - 1 < s.length() && isPalindrome(s, i - indexMinus, i + tmpLength - 1 + indexPlus)) {
                    tmpAnswer = s.substring(i - indexMinus, i + tmpLength + indexPlus);
                    indexMinus++;
                    indexPlus++;
                }
                if (tmpAnswer.length() > answer.length()) {
                    answer = tmpAnswer;
                }
            } else {
                indexPlus--;
                while (i - indexMinus >= 0 && i + indexPlus < s.length() && isPalindrome(s, i - indexMinus, i + indexPlus)) {
                    tmpAnswer = s.substring(i - indexMinus, i + indexPlus + 1);
                    indexMinus++;
                    indexPlus++;
                }
                if (tmpAnswer.length() > answer.length()) {
                    answer = tmpAnswer;
                }
            }
        }
        return answer;
    }

    public static boolean isPalindrome(String s, int index1, int index2) {
        return s.charAt(index1) == s.charAt(index2);
    }
}