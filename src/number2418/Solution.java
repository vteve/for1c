package number2418;

import java.util.*;

class Table {
    public String name;
    public int height;

    Table(String name, int height) {
        this.height = height;
        this.name = name;
    }
}

class Solution1 {
    public static void main(String[] args) {
        sortPeople(new String[]{"1", "2"}, new int[]{1, 2});
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        List<Table> table = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            table.add(new Table(names[i], heights[i]));
        }
        Comparator<Table> comparator = Comparator.comparing(obj -> -obj.height);
        table.sort(comparator);
        String[] anss = new String[names.length];
        for (int i = 0; i < anss.length; i++) {
            anss[i] = table.get(i).name;
        }
        return anss;
    }
}

//2nd solution (my lovely)

public class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;

        Integer[] indexs = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = i;
        }

        Arrays.sort(indexs, (a, b) -> heights[b] - heights[a]);

        String[] anss = new String[n];
        for (int i = 0; i < n; i++) {
            anss[i] = names[indexs[i]];
        }

        return anss;
    }
}
