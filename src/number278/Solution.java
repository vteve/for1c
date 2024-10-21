package number278;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl{
    private int a;
}

public class Solution extends VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (isBadVersion(middle) == true) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}