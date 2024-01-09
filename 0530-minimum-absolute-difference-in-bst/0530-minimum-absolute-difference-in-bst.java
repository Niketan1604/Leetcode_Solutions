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

// using brute force
// class Solution {
//     List<Integer> list;
//     void preorder(TreeNode root){
//         if(root == null) return;

//         list.add(root.val);
//         preorder(root.left);
//         preorder(root.right);
//     }
//     public int getMinimumDifference(TreeNode root) {
//         list = new ArrayList<>();
//         preorder(root);
//         Collections.sort(list);
//         int min = 100001;
//         for(int i=1; i<list.size(); i++){
//             min = Math.min(min, list.get(i) - list.get(i-1));
//         }
//         return min;

//     }
// }

// using bst constraints
class Solution {
    int lastval=-1;
    int min =Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        
        inorder(root);
        return min;
    }

    void inorder(TreeNode root){
        if(root==null)
        return ;

        inorder(root.left);
        if(lastval!=-1){
            if(root.val-lastval < min)
            min = root.val -lastval;
        }
        lastval = root.val;

        inorder(root.right);
        
    }
}