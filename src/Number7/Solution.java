package Number7;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(1563847412));
    }

    public static int reverse(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        int number = x, newNumber = 0;
        int counter = 0;
        while (number != 0) {
            queue.add(number % 10);
            number = number / 10;
            counter++;
        }
        int counter2 = counter;
        while (counter > 0) {
            int elementOfQueue = queue.poll();
            if (x >= 0 && counter2 == 10 && (int) (newNumber / Math.pow(10, counter)) == (int) (Integer.MAX_VALUE / Math.pow(10, counter))
                    && elementOfQueue > (int) (Integer.MAX_VALUE / Math.pow(10, counter - 1)) % 10) {
                return 0;
            } else if (x < 0 && counter2 == 10 && (int) (newNumber / Math.pow(10, counter)) == (int) (Integer.MIN_VALUE / Math.pow(10, counter))
                    && elementOfQueue < (int) (Integer.MIN_VALUE / Math.pow(10, counter - 1)) % 10){
                return 0;
            }
            newNumber += Math.pow(10, counter - 1) * elementOfQueue;
            counter--;
        }
        return newNumber;
    }
}
