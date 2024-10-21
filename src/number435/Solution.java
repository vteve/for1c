package number435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 10}, {-100, -2}, {5, 7}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[1]);
        Arrays.sort(intervals, comparator);
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = intervals[i - 1][1];
                ans++;
            }
        }
        return ans;
    }
}
