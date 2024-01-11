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
    int sum = 0;
    void recursion(int n, TreeNode root){
        if(root.left == null && root.right == null){
            n = n*10 + root.val;
            sum+=n;
            return;
        }

        n = n*10 + root.val;
        if(root.left!=null) recursion(n,root.left);
        if(root.right!=null) recursion(n,root.right);
    }
    public int sumNumbers(TreeNode root) {
        recursion(0,root);
        return sum;

    }
}