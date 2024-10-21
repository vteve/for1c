package number49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] symbols = str.toCharArray();
            Arrays.sort(symbols);
            String sortedWord = Arrays.toString(symbols);
            if (!map.containsKey(Arrays.toString(symbols))) {
                map.put(Arrays.toString(symbols), new ArrayList<>());
            }
            map.get(sortedWord).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
