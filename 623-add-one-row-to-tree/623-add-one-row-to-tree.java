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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode now = new TreeNode(val);
            now.left=root;
            return now;
        }
        bfs(depth-1,root,val);
        return root;
    }
    
    private void bfs(int dep,TreeNode root,int val){
        if(dep==1){
            TreeNode ll = new TreeNode(val);
            TreeNode rr = new TreeNode(val);
            if(root.left != null){
                ll.left=root.left;
                root.left=ll;
            }else{
                //last node
                root.left=ll;
                ll.left=null;
                ll.right=null;
            }
            if(root.right!=null){
                rr.right=root.right;
                root.right=rr;
            }
            else{
                //last node
                root.right=rr;
                rr.left=null;
                rr.left=null;
            }
            return;
        }else{
            if(root.left!=null)bfs(dep-1,root.left,val);
            if(root.right!=null)bfs(dep-1,root.right,val);
        }
    }
}