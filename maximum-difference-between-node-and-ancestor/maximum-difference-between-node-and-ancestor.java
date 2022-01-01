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
   
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
    
    result=0;
    result = helper(root,root.val,root.val);
    return result;
    }
//     o(n)
    private int  helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return curMax - curMin;
        }
        // update `result`
       
        // update the max and min
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
//         maximum from eft and right subtree
        return Math.max(helper(node.left,curMax,curMin), helper(node.right, curMax,curMin));
    }
    
//     o(n^2)
     int result=0;
    void helper2(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return;
        }
        // update `result`
        int possibleResult = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
        result = Math.max(result, possibleResult);
        // update the max and min
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        helper(node.left, curMax, curMin);
        helper(node.right, curMax, curMin);
        return;
    }
}