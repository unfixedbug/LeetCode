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
    TreeMap<Integer, List<Pair<Integer,Integer>>> mp = new TreeMap<>();
    
    private void solve(TreeNode root, int row, int col){
        if(root == null){
            return;
        }
        
        List<Pair<Integer,Integer>> list = mp.getOrDefault(col, new ArrayList<>());
        list.add(new Pair(row, root.val));
        mp.put(col, list);
        
        solve(root.left, row+1, col-1);
        solve(root.right, row+1, col+1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(root, 0, 0);
        
        for(Integer i: mp.keySet()){
            Collections.sort(mp.get(i), (a,b)->{
                if(a.getKey()==b.getKey()){
                    return a.getValue()-b.getValue();
                }
                return a.getKey()-b.getKey();
            });
            List<Pair<Integer, Integer>> pr = mp.get(i);
            List<Integer> arr = new ArrayList<>();
            int n = pr.size();
            for(int j=0;j<n;j++){
                arr.add(pr.get(j).getValue());
            }
            ans.add(arr);
        }
        return ans;
    }
}