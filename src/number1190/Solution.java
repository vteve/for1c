package number1190;

public class Solution {
    public static String recurrentSwap(StringBuilder stringBuilder) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(') {
                index1 = i + 1;
            } else if (stringBuilder.charAt(i) == ')') {
                index2 = i;
                break;
            }
        }
        if (index1 == -1 && index2 == -1) {
            return stringBuilder.toString();
        } else {
            StringBuilder partOfString = new StringBuilder(stringBuilder.substring(index1, index2)).reverse();
            stringBuilder.delete(index1 - 1, index2 + 1);
            stringBuilder.insert(index1 - 1, partOfString);
            return recurrentSwap(stringBuilder);
        }
    }

    public static String reverseParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        return recurrentSwap(stringBuilder);
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
