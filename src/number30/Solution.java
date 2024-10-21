package number30;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static int count2(String[] words, String src) {
        int count = 0;
        for (String word : words) {
            if (word.equals(src)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int sLength = s.length(), wordsLength = words.length, oneWordLength = words[0].length();
        if (sLength < oneWordLength * wordsLength) {
            return list;
        }
        int[] map = new int[wordsLength];
        StringBuilder sSub = new StringBuilder(s.substring(0, wordsLength * oneWordLength));

        for (int i = 0; i < wordsLength; i++) {
            map[i] += count2(words, words[i]);
            if (sSub.toString().contains(words[i])) {
                map[i] -= count(sSub.toString(), words[i]);
            }
        }
        int diffCount = 0;
        for (int diff : map) {
            if (diff != 0) {
                diffCount++;
            }
        }
        if (diffCount == 0) {
            list.add(0);
        }

        int n = sLength - wordsLength * oneWordLength + 1;

        for (int i = 1; i < n; i++) {
            sSub.deleteCharAt(0);
            sSub.append(s.charAt(i + wordsLength * oneWordLength - 1));
            for (int j = 0; j < wordsLength; j++) {
                map[j] = 0;
                map[j] += count2(words, words[j]);
                if (sSub.toString().contains(words[j])) {
                    map[j] -= count(sSub.toString(), words[j]);
                }
            }
            diffCount = 0;
            for (int diff : map) {
                if (diff != 0) {
                    diffCount++;
                }
            }
            if (diffCount == 0) {
                list.add(i - wordsLength * oneWordLength + 1);
            }
        }

        return list;
    }
}
