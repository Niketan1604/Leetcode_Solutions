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
    TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer,Integer> map, int p_start, int p_end, int i_start, int i_end){
        if(p_start > p_end || i_start > i_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int i = map.get(root.val);

        int numsleft = i-i_start;
        root.left = helper(preorder,inorder,map,p_start+1,p_start+numsleft,i_start,i-1);

        root.right = helper(preorder,inorder,map,p_start+numsleft+1,p_end,i+1,i_end);
        

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i],i);

        TreeNode root = helper(preorder,inorder,map,0,preorder.length-1,0,inorder.length-1);
        return root;
        
    }
}