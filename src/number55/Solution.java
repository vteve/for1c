package number55;

public class Solution {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 0, 1, 0}));
    }

    public static boolean canJump(int[] nums) {
        int lastIndexVisited = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i <= lastIndexVisited) {
                lastIndexVisited = Math.max(lastIndexVisited, i + nums[i]);
            }
        }
        return lastIndexVisited >= nums.length - 1;
    }
}
