package number560;

import java.util.HashMap;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(currentSum, 1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}