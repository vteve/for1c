package number1593;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("wwwzfvedwfvhsww"));
    }

    public static int maxUniqueSplit(String s) {
        int index1 = 0, index2 = 0;
        Set<String> map = new HashSet<>();
        int answer = 0;
        int lastAddIndex = -1;

        while (index2 < s.length()) {
            if (!map.contains(s.substring(index1, index2 + 1))) {
                map.add(s.substring(index1, index2 + 1));
                lastAddIndex = index2;
                index1 = index2 + 1;
                answer++;
            }
            index2++;
        }

        if (lastAddIndex != s.length() - 1 && map.contains(s.substring(lastAddIndex + 1))) {

        }

        return answer;
    }
}
