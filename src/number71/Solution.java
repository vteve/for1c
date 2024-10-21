package number71;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        String str = "acbdef";
        System.out.println(str.substring(1, 4));
        string("");
    }

    public static String string(String str) {
        if (str.length() == 5) {
            return str;
        }
        string(str + "a");
        return str;
    }

    public static String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder string = new StringBuilder();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) deque.pop();
            } else if (!str.equals("") && !str.equals(".")) {
                deque.push("/" + str);
            }
        }
        while (deque.size() > 0) {
            string.append(deque.getLast());
            deque.removeLast();
        }
        if (string.length() == 0) {
            string.append("/");
        }
        return string.toString();
    }
}
