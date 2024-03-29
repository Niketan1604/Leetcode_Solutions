/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // if(root.val > targetSum) return false;
        if(targetSum-root.val == 0 && root.left == null && root.right == null) return true;
        if(root.left!=null && hasPathSum(root.left, targetSum - root.val)) return true;
        if(root.right!=null && hasPathSum(root.right, targetSum - root.val)) return true;

        return false;
    }
}