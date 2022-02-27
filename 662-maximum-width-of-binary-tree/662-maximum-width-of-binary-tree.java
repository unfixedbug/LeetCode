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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        q.offer(root);
        map.put(root,1);
        int curw = 0,maxw=0;
        while(!q.isEmpty()){
            int size = q.size();
            int start=0;
            int end=0;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==0)start=map.get(curr);
                if(i==size-1)end = map.get(curr);
                if(curr.left !=null){
                    map.put(curr.left, map.get(curr)*2);
                    q.offer(curr.left);
                }
                if(curr.right !=null){
                    map.put(curr.right, map.get(curr)*2+1);
                    q.offer(curr.right);
                }
            }
            curw = end-start+1;
            maxw = Math.max(curw, maxw);
        }
        return maxw;
    }
}