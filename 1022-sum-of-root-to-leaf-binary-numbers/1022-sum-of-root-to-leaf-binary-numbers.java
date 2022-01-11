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
    public int sumRootToLeaf(TreeNode root) {
        
        // current number
        int ans= 0, cn = 0;
        Deque<Pair<TreeNode, Integer>> stack  = new ArrayDeque();
        
        stack.push(new Pair(root, 0));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> p =  stack.pop();
            root = p.getKey();
            cn = p.getValue();
            
            if(root!=null){ //traverse
                cn = (cn<<1) | root.val;
                // if leaf, update ans;
                if(root.left ==null && root.right ==null){
                    ans+= cn;
                }else{
                    stack.push(new Pair(root.left,cn));
                    stack.push(new Pair(root.right,cn));
                }
                
            }
        }
                   return ans;
    }
}