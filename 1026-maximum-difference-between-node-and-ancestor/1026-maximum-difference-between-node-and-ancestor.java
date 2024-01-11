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
    int max;
    void helper(TreeNode root, int max_a, int min_a){ // a -> ancestor node value
        if(root == null) return;
        int diff = Math.max(Math.abs(max_a-root.val),Math.abs(min_a-root.val));
        max = Math.max(max,diff);
        helper(root.left, Math.max(max_a,root.val),Math.min(min_a,root.val));
        helper(root.right, Math.max(max_a,root.val),Math.min(min_a,root.val));
    }
    public int maxAncestorDiff(TreeNode root) {
        max = 0;
        helper(root,root.val,root.val);

        return max;
    }
}