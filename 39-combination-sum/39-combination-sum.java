class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int el:candidates)set.add(el);
        
        ArrayList<Integer> cand = new ArrayList<>(set);
        Collections.sort(cand);
         helper(cand,ans,target,0,temp);
        return ans;
    }
    
    public void helper(ArrayList<Integer> cand, List<List<Integer>> ans, int sum,int index, List<Integer> temp){
        if(sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<cand.size();i++){
            if(sum -cand.get(i) >=0 ){//we want it
                temp.add(cand.get(i));
                helper(cand,ans,sum-cand.get(i),i,temp);
                temp.remove(cand.get(i));
            }
        }
    }
}