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
    private  int cameras=0;
    
    public int minCameraCover(TreeNode root) {
        return helper(root)==-1?cameras+1:cameras;
    }
    // -1: NOT MONITORED
    //  0: MONITORED
    //  1: HAS CAMERA
    
    private int helper(TreeNode root){
        if(root==null)return 0;// already covered;
        
        int leftChild = helper(root.left);
        int rightChild = helper(root.right);
        
        if(leftChild ==-1 || rightChild==-1){
            cameras++; // one of the childs need camera
            return 1; // tell parent that, i have camera, i dont need any
        }
        if(leftChild==1 || rightChild==1){
            return 0;// i got covered
        }
        return -1;// im not covered, see me
    }
}