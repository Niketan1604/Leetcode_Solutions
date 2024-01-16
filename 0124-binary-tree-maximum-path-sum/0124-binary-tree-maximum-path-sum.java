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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        sum(root);
        return maxi;
    }

    int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        ls = ls>0?ls:0;
        rs = rs>0?rs:0;
        maxi = Math.max(maxi,root.val+ls+rs);

        return root.val+Math.max(ls,rs);
    }
}