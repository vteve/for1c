package number2678;

public class Solution {

    public static int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            if (details[i].charAt(11) - '0' > 6 || details[i].charAt(11) - '0' == 6 && details[i].charAt(12) - '0' != 0) {
                count++;
            }
        }
        return count;
    }
}
