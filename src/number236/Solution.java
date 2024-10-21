package number236;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int HeightOfTree(TreeNode node) {
        if (node == null)
            return 0;
        int left, right;
        if (node.left != null) {
            left = HeightOfTree(node.left);
        } else
            left = -1;
        if (node.right != null) {
            right = HeightOfTree(node.right);
        } else
            right = -1;
        int max = Math.max(left, right);
        return max + 1;
    }
}
