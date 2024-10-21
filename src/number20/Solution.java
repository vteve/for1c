package number20;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("([[]])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char symbol : s.toCharArray()) {
            if (symbol == '(')
                stack.push(')');
            else if (symbol == '{')
                stack.push('}');
            else if (symbol == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != symbol)
                return false;
        }
        return stack.isEmpty();
    }
}
