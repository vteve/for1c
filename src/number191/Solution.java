package number191;

public class Solution {
    public int hammingWeight(int n) {
        int answer = 0, number;
        while (n > 0) {
            number = n % 2;
            if (n % 2 == 1) {
                answer++;
            }
            n = n / 2;
        }
        return answer;
    }
}
