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
    
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        dfs(root,targetSum,new ArrayList<Integer>());
        return res;
    }
    private void dfs(TreeNode root, int sum,ArrayList<Integer> cur){
        if(root==null)return;
        // if(root.val>sum)return;
        
        
        if(root.left==null && root.right==null &&sum==root.val){
            cur.add(root.val);
            res.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }
        cur.add(root.val);
        dfs(root.right,sum-root.val,cur);
        dfs(root.left,sum-root.val,cur);
        cur.remove(cur.size()-1);
    }
}