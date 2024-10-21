package number4;

//public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double answer = 0;
//        int[] mergedArray = new int[nums1.length + nums2.length];
//        int indexNums1 = 0, indexNums2 = 0;
//        for (int i = 0; i < mergedArray.length; i++) {
//            if (indexNums1 >= nums1.length) {
//                mergedArray[i] = nums2[indexNums2];
//                indexNums2++;
//            } else if (indexNums2 >= nums2.length) {
//                mergedArray[i] = nums1[indexNums1];
//                indexNums1++;
//            } else if (nums1[indexNums1] <= nums2[indexNums2]) {
//                mergedArray[i] = nums1[indexNums1];
//                indexNums1++;
//            } else {
//                mergedArray[i] = nums2[indexNums2];
//                indexNums2++;
//            }
//        }
//        if (mergedArray.length % 2 == 1) {
//            answer = mergedArray[mergedArray.length / 2];
//        } else {
//            answer = (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
//        }
//        return answer;
//    }
//}

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 5, 7, 9, 10, 14, 15, 16, 18, 123, 1056}, new int[]{2, 3, 4, 5, 8, 100, 123, 653, 763}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int partition = (n + 1) / 2;

        if (n1 == 0)
            return n2 % 2 != 0 ? nums2[n2 / 2] : (nums2[n2 / 2] + nums2[n2 / 2 - 1]) / 2.0;

        int left1 = 0;
        int right1 = n1;
        int cut1, cut2;
        int l1, r1, l2, r2;

        do {
            cut1 = (left1 + right1) / 2;
            cut2 = partition - cut1;

            l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];

            l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            r1 = cut1 >= n1 ? Integer.MAX_VALUE : nums1[cut1];

            r2 = cut2 >= n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1)
                return n % 2 != 0 ? Math.max(l1, l2) : (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            else if (l1 > r2)
                right1 = cut1 - 1;
            else
                left1 = cut1 + 1;
        } while (left1 <= right1);

        return 0.0;
    }
}

