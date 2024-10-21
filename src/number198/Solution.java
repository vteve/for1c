package number198;

class Solution {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        int rob = 0, noRob = 0;
        for (int num : nums) {
            int newRob = noRob + num;
            int newNoRob = Math.max(noRob, rob);
            rob = newRob;
            noRob = newNoRob;
        }
        return Math.max(rob, noRob);
    }
}