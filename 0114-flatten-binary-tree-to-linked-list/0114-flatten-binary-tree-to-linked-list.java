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

// with o(n) space
// class Solution {
//     void recursion(TreeNode root, Queue<TreeNode> q){
//         if(root == null) return;
//         q.add(root);
//         recursion(root.left,q);
//         recursion(root.right,q);
//     }
//     public void flatten(TreeNode root) {
//         if(root == null || (root.left==null && root.right==null)) return;
//         Queue<TreeNode> q = new LinkedList<TreeNode>();
//         recursion(root,q);
//         while(!q.isEmpty()){
//             root.left = null;
//             root.right = q.remove();

//             root = root.right;
//         }

//     }
// }

//with o(1) space
class Solution {
    TreeNode head = null;
    public void flatten(TreeNode root) {
        if (root != null) revPreOrder(root);
    }
    private void revPreOrder(TreeNode node) {
        if (node.right != null) revPreOrder(node.right);
        if (node.left != null) revPreOrder(node.left);
        node.left = null;
        node.right = head;
        head = node;
    }
}