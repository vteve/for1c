package number26;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Solution {
    //    public int removeDuplicates1(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        int k = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (!set.contains(nums[i])) {
//                set.add(nums[i]);
//                nums[k] = nums[i];
//                k++;
//            }
//        }
//        return k;
//    }
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
