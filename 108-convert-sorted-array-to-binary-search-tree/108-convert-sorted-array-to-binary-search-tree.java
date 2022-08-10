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
    int[]nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        this.nums=nums;
        TreeNode cur = helper(0,nums.length-1);
        return cur;
    }
    
    private TreeNode helper(int l, int r){
        if(l>r)return null;
        
        int mid = (l+r)>>1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(l,mid-1);
        node.right = helper(mid+1,r);
        
        return node;
    }
}