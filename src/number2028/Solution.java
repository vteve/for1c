package number2028;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[]{1}, 3, 1)));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int capacity = (rolls.length + n) * mean;
        for (int roll : rolls) {
            capacity -= roll;
        }
        if (capacity > n * 6 || capacity < n) {
            return new int[0];
        }
        capacity -= n;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int index = 0;
        while (capacity > 0) {
            while (answer[index] < 6 && capacity > 0) {
                capacity--;
                answer[index]++;
            }
            index++;
        }
        return answer;
    }
}
