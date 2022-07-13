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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        return helper(root);
    }
    
    private List<List<Integer>> helper(TreeNode root){    
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        // curr.add(root.val);
        // ans.add(new ArrayList(curr));
        // while que is not empty;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            curr = new ArrayList<>();
            while(size-->0){
                TreeNode now = q.poll();
                if(now.left!=null)q.add(now.left);
                if(now.right!=null)q.add(now.right);
                curr.add(now.val);
            }
            // add current list to anser
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }
}