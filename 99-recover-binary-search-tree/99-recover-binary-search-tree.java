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
    
    TreeNode prev=null, first  =null, second =null;
    public void recoverTree(TreeNode root) {
        swappedNode(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void swappedNode(TreeNode curr){
        if(curr==null)return;// reachded deadend
        // do inorder traversal
        swappedNode(curr.left);
        
        if(prev!=null && prev.val > curr.val){
            if(first==null){
                first = prev;
            }
            second  = curr;   
        }
        
        prev = curr;
        swappedNode(curr.right);
    }
    
    // traverse in the tree, if mismatched, swap, else move forward
}