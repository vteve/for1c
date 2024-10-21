package number443;

public class Solution {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    public static int compress(char[] chars) {
        int i = 0, count = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[count++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[count++] = c;
                }
            }
            i += groupLength;
        }
        return count;
    }
}