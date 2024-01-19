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
    TreeNode helper(int[] inorder,int i_start,int i_end, int[] postorder, int p_start, int p_end, Map<Integer,Integer> map){
        if(i_start > i_end || p_start > p_end) return null;
        TreeNode root = new TreeNode(postorder[p_end]);

        int curr = map.get(root.val); 
        int numsright = i_end - curr;

        root.left = helper(inorder,i_start,curr-1,postorder,p_start,p_end-numsright-1,map);

        root.right = helper(inorder,curr+1,i_end,postorder,p_end-numsright,p_end-1,map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i],i);
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
}