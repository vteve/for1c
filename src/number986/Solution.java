package number986;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int length1 = firstList.length;
        int length2 = secondList.length;
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            int[] tmp = new int[2];
            if ((tmp = intersection(firstList[i], secondList[j])) != null) {
                list.add(tmp);
            }
            if (firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        int[][] ans = toMatrix(list);
        return ans;
    }

    private static int[][] toMatrix(List<int[]> a) {
        int[][] res = new int[a.size()][2];
        for (int i = 0; i < a.size(); i++) {
            res[i] = a.get(i);
        }
        return res;
    }

    public static int[] intersection(int[] arr1, int[] arr2) {
        int[] ans = new int[2];
        ans[0] = Math.max(arr1[0], arr2[0]);
        ans[1] = Math.min(arr1[1], arr2[1]);
        if (ans[0] > ans[1]) {
            return null;
        }
        return ans;
    }
}
