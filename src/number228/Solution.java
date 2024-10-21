package number228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            List<String> a = new ArrayList<>();
            a.add(String.valueOf(nums[0]));
            return a;
        }
        List<String> answer = new ArrayList<>();
        int number = nums[0];
        int countNumbers = 1;
        int index1 = 0, index2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (index1 != index2) {
                    if (nums[i] - nums[i - 1] == 1) {
                        answer.add(nums[index1] + "->" + nums[index2 + 1]);
                    } else {
                        answer.add(nums[index1] + "->" + nums[index2]);
                        answer.add(String.valueOf(nums[i]));
                    }
                } else {
                    if (nums[i] - nums[i - 1] == 1) {
                        answer.add(nums[index1] + "->" + nums[index2 + 1]);
                    } else {
                        answer.add(String.valueOf(nums[index1]));
                        answer.add(String.valueOf(nums[index1 + 1]));
                    }
                }
            } else if (nums[i] - nums[i - 1] == 1) {
                index2++;
            } else {
                if (index1 != index2) {
                    answer.add(nums[index1] + "->" + nums[index2]);
                } else {
                    answer.add(String.valueOf(nums[index1]));
                }
                index1 = i;
                index2 = i;
            }
        }
        return answer;
    }
}
