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
    List<Integer> list;
    void preorder(TreeNode root){
        if(root == null) return;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        preorder(root);

        Collections.sort(list);
        return list.get(k-1);
    }
}