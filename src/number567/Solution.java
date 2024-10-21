package number567;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int lengthS1;
        if ((lengthS1 = s1.length()) > s2.length()) {
            return false;
        }
        int[] mask1 = new int[26];
        int[] mask2 = new int[26];
        for (int i = 0; i < lengthS1; i++) {
            mask1[s1.charAt(i) - 'a']++;
            mask2[s2.charAt(i) - 'a']++;
        }
        int index1 = 0, index2 = lengthS1 - 1;
        if (checkMask(mask1, mask2)) {
            return true;
        }
        while (index2 < s2.length() - 1) {
            index1++;
            index2++;
            mask2[s2.charAt(index2) - 'a']++;
            mask2[s2.charAt(index1 - 1) - 'a']--;
            if (checkMask(mask1, mask2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkMask(int[] mask1, int[] mask2) {
        for (int i = 0; i < 26; i++) {
            if (mask1[i] != mask2[i]) {
                return false;
            }
        }
        return true;
    }

}
