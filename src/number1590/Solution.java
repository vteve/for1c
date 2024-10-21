package number1590;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        minSubarray(new int[]{3, 1, 4, 2}, 6);
    }

    public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int target = 0;

        for (int num : nums) {
            target = (target + num) % p;
        }

        if (target == 0) {
            return 0;
        }

        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);
        int currentSum = 0;
        int minLen = n;

        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            int needed = (currentSum - target + p) % p;

            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            modMap.put(currentSum, i);
        }

        return minLen == n ? -1 : minLen;
    }
}
