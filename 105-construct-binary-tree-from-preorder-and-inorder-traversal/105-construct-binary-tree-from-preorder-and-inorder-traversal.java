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
    int pIndex;//preorder index
    Map<Integer, Integer> inordermap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pIndex=0;
        //map has value -> index
        inordermap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        
        return constructed(preorder,0,preorder.length-1);
    }
    
    private TreeNode constructed(int[] preorder,int left, int right){
        if(left>right)return null;
        
        int rootval = preorder[pIndex++];
        TreeNode root = new TreeNode(rootval);// first is alwas a root
        
        int rootindex=inordermap.get(rootval);
        root.left = constructed(preorder,left,rootindex-1);
        root.right = constructed(preorder,rootindex+1,right);
        return root;
    }
}