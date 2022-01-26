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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        traverse(root1,q1);
        traverse(root2,q2);
        List<Integer> ans = new ArrayList<>();
        while(!q1.isEmpty() || !q2.isEmpty()){
            if(q2.isEmpty()){
                ans.add(q1.poll());
            }else if(q1.isEmpty()){
                ans.add(q2.poll());
            }
            else{// both are nonempty
                ans.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
            }
        }
        return ans;
        
    }
    
    public void traverse(TreeNode root, Queue<Integer> q){
        if(root==null) return;
        traverse(root.left,q);
        q.offer(root.val);
        traverse(root.right,q);
        // inorder traversal
    }
}