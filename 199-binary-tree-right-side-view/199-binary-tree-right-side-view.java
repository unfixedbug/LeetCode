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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> deq = new ArrayDeque<>();
        deq.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr=new TreeNode(0);
        while(!deq.isEmpty()){
            // size of the current level
            int i=0;
            int size = deq.size();
            while(i++<size){
                curr = deq.poll();
                
                // last element
                if(i==size)ans.add(curr.val);
                if(curr.left!=null)deq.add(curr.left);
                
                if(curr.right!=null)deq.add(curr.right);
            }
        }
        return ans;
    }
}