package number2248;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        intersection(new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}});
    }

    public static List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums[0].length; i++) {
            map.put(nums[0][i], 1);
        }
        for (int i = 1; i < nums.length; i++) {
            boolean[] flags = new boolean[nums[i].length];
            int indexOfFlag = 0;
            for (int j = 0; j < nums[i].length; j++) {
                if (!flags[indexOfFlag] && map.containsKey(nums[i][j])) {
                    flags[indexOfFlag] = true;
                    indexOfFlag++;
                    map.put(nums[i][j], map.get(nums[i][j]) + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
}
