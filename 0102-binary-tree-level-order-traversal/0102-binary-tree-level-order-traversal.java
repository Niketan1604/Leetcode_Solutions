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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> arr = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<>();
        arr.add(root);
        arr.add(null);
        while(!arr.isEmpty()){
            TreeNode node = arr.remove();
            if(node == null){
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                if(arr.isEmpty()) break;
                else arr.add(null);
            }
            else{
                if(node.left!=null) arr.add(node.left);
                if(node.right!=null) arr.add(node.right);
                list.add(node.val);
            }

        }
        return res;
    }
}