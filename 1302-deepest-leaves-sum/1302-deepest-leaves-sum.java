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
    public int deepestLeavesSum(TreeNode root) {
        int height = depth(root);
        return helper(root,height,1);
    }
    public int depth(TreeNode root){
        if(root==null)return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
    public int helper(TreeNode root,int d,int now){
        
            int ans=0;
        if(now==d){
            return root.val;
        }
        else {
            if(root.right!=null){
                ans+=helper(root.right,d,now+1);
            }
            if(root.left!=null){
                ans+=helper(root.left,d,now+1);
            }
    
        return ans;
    }}
}