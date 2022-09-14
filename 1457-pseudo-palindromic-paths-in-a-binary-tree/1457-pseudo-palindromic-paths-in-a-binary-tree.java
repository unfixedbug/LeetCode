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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int count) {
        if (root == null) return;
        count ^= 1 << (root.val - 1);
        dfs(root.left, count);
        dfs(root.right, count);
        if (root.left == null && root.right ==  null && (count & (count - 1)) == 0) ans++;
    }
}