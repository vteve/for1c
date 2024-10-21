package number1004;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    public static int longestOnes(int[] nums, int k) {
        int index1 = 0, index2 = 0;
        int countZero = 0;
        int number = 0, maxNumber = 0;
        while (index2 < nums.length) {
            if (nums[index2] == 1) {
                number++;
                index2++;
                maxNumber = Math.max(number, maxNumber);
            } else {
                if (countZero < k) {
                    countZero++;
                    index2++;
                    number++;
                    maxNumber = Math.max(number, maxNumber);
                } else {
                    while (nums[index1] == 1) {
                        index1++;
                        number--;
                    }
                    index1++;
                    countZero--;
                    number--;
                }
            }
        }
        return maxNumber;
    }
}
