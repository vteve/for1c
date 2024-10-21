package number11;

public class Solution {
    public int maxArea(int[] height) {
        int answer = 0, leftIndex = 0, rightIndex = height.length - 1;
        while (leftIndex <= rightIndex) {
            answer = Math.max(answer, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return answer;
    }
}
