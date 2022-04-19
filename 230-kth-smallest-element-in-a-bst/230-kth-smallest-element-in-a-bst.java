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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = traverse(root,new ArrayList<Integer>());
        return ans.get(k-1); /// 1 based indexing
    }

    private ArrayList<Integer> traverse(TreeNode root, ArrayList<Integer> arr){
        // arr will contain its smallest element at first
        
        if(root==null)return arr;
        traverse(root.left, arr); //
        arr.add(root.val);
        traverse(root.right, arr);
        return arr;
    }
}