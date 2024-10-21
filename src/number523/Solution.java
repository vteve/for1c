package number523;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{1, 1}, 2));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = currentSum % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
