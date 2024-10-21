package number1493;

public class Solution {
    //    public int longestSubarray(int[] nums) {
//        return Math.max(longestOnes(nums, 1) - 1, 0);
//    }
    public static void main(String[] args) {
        longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
    }

    public static int longestSubarray(int[] nums) {
        int index1 = 0, index2 = 0;
        int number = 0, maxNumber = 0, countZero = 0;
        while (index2 < nums.length) {
            if (nums[index2] == 1) {
                number++;
                maxNumber = Math.max(number, maxNumber);
                index2++;
            } else {
                if (countZero < 1) {
                    countZero++;
                    maxNumber = Math.max(number, maxNumber);
                    index2++;
                } else {
                    while (nums[index1] == 1) {
                        index1++;
                        number--;
                    }
                    index1++;
                    countZero--;
                }
            }
        }
        return Math.min(maxNumber, nums.length - 1);
    }

//    public static int longestOnes(int[] nums, int k) {
//        int index1 = 0, index2 = 0;
//        int countZero = 0;
//        int number = 0, maxNumber = 0;
//        while (index2 < nums.length) {
//            if (nums[index2] == 1) {
//                number++;
//                index2++;
//                maxNumber = Math.max(number, maxNumber);
//            } else {
//                if (countZero < k) {
//                    countZero++;
//                    index2++;
//                    number++;
//                    maxNumber = Math.max(number, maxNumber);
//                } else {
//                    while (nums[index1] == 1) {
//                        index1++;
//                        number--;
//                    }
//                    index1++;
//                    countZero--;
//                    number--;
//                }
//            }
//        }
//        return maxNumber;
//    }
}
