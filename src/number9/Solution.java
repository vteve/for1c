package number9;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            Deque<Integer> deque = new ArrayDeque<>();
            while (x > 0) {
                deque.push(x % 10);
                x = x / 10;
            }
            int firstNumber;
            int secondNumber;
            while (!deque.isEmpty()) {
                firstNumber = deque.removeFirst();
                if (!deque.isEmpty()) {
                    secondNumber = deque.removeLast();
                } else {
                    return true;
                }
                if (firstNumber != secondNumber) {
                    return false;
                }
            }
            return true;
        }
    }
}
