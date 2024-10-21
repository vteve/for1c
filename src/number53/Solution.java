package number53;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-10, -1, -12, -3}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
