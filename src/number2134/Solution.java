package number2134;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        minSwaps(new int[]{1, 1, 1, 0, 1, 1, 0, 0});
    }

    public static int minSwaps(int[] nums) {
        String strNums = Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
        System.out.println(strNums);
        String[] arrStrs = strNums.split("1");
        for (int i = 0; i < arrStrs.length; i++) {
            System.out.println(arrStrs[i]);
        }
        int numsLength = nums.length, countUnits = 0, maxCountTogetherUnits = 0, tmp = 0;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == 1) {
                countUnits++;
                tmp++;
            } else {
                maxCountTogetherUnits = Math.max(maxCountTogetherUnits, tmp);
                tmp = 0;
            }
        }
        return 0;
    }
}
