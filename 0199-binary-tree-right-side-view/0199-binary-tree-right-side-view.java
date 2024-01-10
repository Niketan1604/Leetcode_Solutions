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
    void helper(TreeNode root, List<Integer> list, int i){
        if(list.size() <= i) list.add(root.val);
        else list.set(i,root.val);
        if(root.left != null){
            helper(root.left,list,i+1);
        }
        if(root.right != null){
            helper(root.right,list,i+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root,list,0);

        return list;
    }
}