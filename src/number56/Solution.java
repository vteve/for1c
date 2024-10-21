package number56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int indexOfList = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (!intersection(list.get(indexOfList), intervals[i])) {
                list.add(intervals[i]);
                indexOfList++;
            } else {
                int[] m = list.get(indexOfList);
                list.remove(indexOfList);
                list.add(new int[]{m[0], Math.max(m[1], intervals[i][1])});
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static boolean intersection(int[] arr1, int[] arr2) {
        return arr1[1] >= arr2[0];
    }
}
