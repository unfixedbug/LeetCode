/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        
        if(root==p || root==q)return root;
        
        TreeNode left_lca = lowestCommonAncestor(root.left, p,q);
        TreeNode right_lca = lowestCommonAncestor(root.right, p,q);
        
        if(left_lca!=null && right_lca!=null)return root;// both exist
        
        // if one of them is null
        return (left_lca!=null)?left_lca:right_lca;
    }
    
    
    
    // returns whether the node is present
    private static boolean isNodePresent(TreeNode root, TreeNode node){
        if(root==node)return true;
        if(root==null)return false;
        
        return isNodePresent(root.left,node) || isNodePresent(root.right,node);
    }
}