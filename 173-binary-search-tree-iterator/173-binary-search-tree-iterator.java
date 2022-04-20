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
class BSTIterator {
    
    private TreeNode now;
    private Queue<Integer> inorder;
    
    public BSTIterator(TreeNode root) {
        now = root;    
        inorder = new PriorityQueue<Integer>();
        traversal(root);
    }
    
    
    private void traversal(TreeNode root){
        if(root!=null){
            traversal(root.left);
            inorder.add(root.val);
            traversal(root.right);
        }
    }
    
    public int next() {
        int next = inorder.poll();
        return next;
    }

    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */