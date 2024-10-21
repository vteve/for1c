package number98;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }

    public boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = checkBST(root.left);
        if (root.val <= prev) {
            return false;
        }
        // move prev node to current root node
        prev = root.val;
        boolean right = checkBST(root.right);

        return left && right;
    }
}
