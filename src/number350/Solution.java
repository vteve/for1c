package number350;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int element : nums1) {
            if (map1.containsKey(element)) {
                map1.put(element, map1.get(element) + 1);
            } else {
                map1.put(element, 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int element : nums2) {
            if (map1.containsKey(element)) {
                if (!map2.containsKey(element)) {
                    map2.put(element, 1);
                } else {
                    if (map2.get(element) < map1.get(element)) {
                        map2.put(element, map2.get(element) + 1);
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
