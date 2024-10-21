package number349;

import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int k : nums1) {
            set1.add(k);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int j : nums2) {
            set2.add(j);
        }
        set1.retainAll(set2);
        int index = 0;
        int[] answer = new int[set1.size()];
        for (int s : set1) {
            answer[index++] = s;
        }
        return answer;
    }
}
