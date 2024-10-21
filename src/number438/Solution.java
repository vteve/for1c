package number438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
//    public static void main(String[] args) {
//        findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
//    }

    public static boolean isAnagram(char[] source, char[] dest) {
        Arrays.sort(source);
        Arrays.sort(dest);
        return Arrays.equals(source, dest);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        if (s.length() < pLength) {
            return new ArrayList<>();
        }
        char[] pCharArr = p.toCharArray();
        List<Integer> list = new ArrayList<>();
        StringBuilder src = new StringBuilder(s.substring(0, pLength));
        if (isAnagram(src.toString().toCharArray(), pCharArr)) {
            list.add(0);
        }
        for (int i = pLength; i < s.length(); i++) {
            src.deleteCharAt(0);
            src.append(s.charAt(i));
            if (isAnagram(src.toString().toCharArray(), pCharArr)) {
                list.add(i - pLength + 1);
            }
        }
        return list;
    }
}


public class Solution {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        var ans = new ArrayList<Integer>();
        int np = p.length(), ns = s.length();
        if (np > ns) {
            return ans;
        }
        int[] map = new int[26];
        for (int i = 0; i < np; i++) {
            map[p.charAt(i) - 'a']++;
            map[s.charAt(i) - 'a']--;
        }
        int diffCount = 0;
        for (int diff : map) {
            if (diff > 0) {
                diffCount++;
            }
        }
        if (diffCount == 0) {
            ans.add(0);
        }
        for (int i = 0, n = ns - np; i < n; i++) {
            if (++map[s.charAt(i) - 'a'] == 1) {
                diffCount++;
            }
            if (--map[s.charAt(i + np) - 'a'] == 0) {
                diffCount--;
            }
            if (diffCount == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}