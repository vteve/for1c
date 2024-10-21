package number1460;

import java.util.Arrays;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int[] map = new int[1001];
        for (int i = 0; i < n; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            if (map[target[i]] != 0 || map[arr[i]] != 0) {
                return false;
            }
        }
        return true;
    }
}
