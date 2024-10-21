package number3;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("      "));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new ArrayDeque<>();
        int max = 0;
        for (char element : s.toCharArray()) {
            if (!set.contains(element)) {
                set.add(element);
                queue.add(element);
                max = Math.max(max, set.size());
            } else {
                char character;
                do {
                    character = queue.remove();
                    set.remove(character);
                } while (character != element);
                set.add(element);
                queue.add(element);
            }
        }
        return max;
    }
}
