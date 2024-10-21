package number88;


class Solution {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int l = m - 1;
        int r = n - 1;
        while (cur >= 0) {
            if (r < 0 || (l >= 0 && nums1[l] > nums2[r])) {
                nums1[cur--] = nums1[l--];
            } else {
                nums1[cur--] = nums2[r--];
            }
        }
    }
}
