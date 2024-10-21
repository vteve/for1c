package number15;

import java.util.*;

//class MyArrayList extends ArrayList<int[]> {
//
//    @Override
//    public boolean contains(Object o) {
//        int[] arr = (int[]) o;
//
//        Arrays.sort(arr);
//
//        for (int[] i : this) {
//            Arrays.sort(i);
//
//            if (Arrays.toString(i).compareTo(Arrays.toString(arr)) == 0) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}
//
//public class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        MyArrayList arrayLists = new MyArrayList();
//        List<List<Integer>> answer = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int lastNumber = -nums[i] - nums[j];
//                if (map.containsKey(lastNumber) && map.get(lastNumber) != i && map.get(lastNumber) != j) {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(lastNumber);
//                    int[] arr = new int[3];
//                    for (int k = 0; k < 3; k++) {
//                        arr[k] = list.get(k);
//                    }
//                    if (!arrayLists.contains(arr)) {
//                        answer.add(list);
//                        arrayLists.add(arr);
//                    }
//                }
//            }
//        }
//        return answer;
//    }
//}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            // Never let i refer to the same value twice to avoid duplicates.
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    output.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    // Never let j refer to the same value twice (in an output) to avoid duplicates
                    while (j < k && nums[j] == nums[j - 1]) ++j;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return output;
    }
}
