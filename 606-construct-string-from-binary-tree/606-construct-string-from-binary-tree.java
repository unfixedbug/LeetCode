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
    String cur="";
    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder("");
        builder.append(root.val);
        
        if (root.left != null || (root.left == null && root.right != null))
            trav(root.left, builder);
        
        if (root.right != null)
            trav(root.right, builder);
        return builder.toString();
    }
    
    void trav(TreeNode root, StringBuilder builder){
       
        if(root==null){
            builder.append("()");
            return;
        }
        builder.append("(");
        builder.append(root.val);
        
        if(root.left!=null ||(root.left == null && root.right != null)){
            trav(root.left,builder);
        }
        if(root.right!=null){
            trav(root.right,builder);
        }
        builder.append(")");
        
      }
}