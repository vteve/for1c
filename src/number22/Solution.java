package number22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        recursion(0, 0, answer, n, "");
        return answer;
    }

    public static void recursion(int left, int right, List<String> list, int n, String s) {
        if (s.length() == n * 2) {
            list.add(s);
            return;
        }
        if (left < n) {
            recursion(left + 1, right, list, n, s + '(');
        }
        if (right < left) {
            recursion(left, right + 1, list, n, s + ')');
        }
    }
}
