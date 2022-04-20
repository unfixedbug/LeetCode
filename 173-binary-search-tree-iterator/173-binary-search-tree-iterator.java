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
    private Stack<TreeNode> inorder;
    
    public BSTIterator(TreeNode root) {
        now = root;    
        inorder = new Stack();
    }
   
    public int next() {
        while(now!=null){// traverse, get its left one first
            inorder.push(now);
            now = now.left;// over the left most?
        }
        TreeNode next = inorder.pop();// traverse its right 
        now = next.right;
        // return the popped node
        return next.val;
    }
    
    public boolean hasNext() {
        return now!=null || !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */