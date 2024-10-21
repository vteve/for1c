package number101;

public class Solution {

    static class TreeNode {
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

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        return isOK(leftRoot, rightRoot);
    }

    public static boolean isOK(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null) {
            return false;
        } else if (node2 == null) {
            return false;
        } else if (node1.val == node2.val) {
            isOK(node1.left, node2.right);
            isOK(node1.right, node2.left);
        }
        return true;
    }

}
