package number849;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 1}));
    }

    public static int maxDistToClosest(int[] seats) {
        int index1 = 0, index2;
        int maxDistance = 0;
        while (seats[maxDistance] != 1) {
            maxDistance++;
        }
        index2 = maxDistance;
        for (int i = maxDistance; i < seats.length; i++) {
            if (seats[i] == 1) {
                index1 = index2;
                index2 = i;
                maxDistance = Math.max(maxDistance, (index2 - index1) / 2);
            }
        }
        index1 = index2;
        maxDistance = Math.max(maxDistance, (seats.length - 1 - index1));
        return maxDistance;
    }
}
