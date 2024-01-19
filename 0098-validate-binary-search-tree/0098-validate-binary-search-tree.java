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

    long prev = Long.MIN_VALUE;
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        return valid;
    }

    private void inorderTraversal(TreeNode root) {
        if(root==null || !valid) return;
        inorderTraversal(root.left);
        if(root.val <= prev) {
            valid = false;
            return;
        } 
        prev = root.val;
        inorderTraversal(root.right);
    }
}