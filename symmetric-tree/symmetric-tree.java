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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);// && isSymmetric()
    }
    
    boolean isSymmetric(TreeNode left_root, TreeNode right_root){
        
        if(left_root != null && right_root != null){
            if(left_root.val != right_root.val) return false;
            return isSymmetric(left_root.left, right_root.right) && isSymmetric(left_root.right, right_root.left);
        }
        if(left_root != null || right_root != null) return false;
        return true;
    }
}