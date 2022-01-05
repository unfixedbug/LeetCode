class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> result = new ArrayList<List<String>>();
        boolean dp[][] = new boolean[len][len];
        dfs(result,0,s,dp, new ArrayList<>());
        return result;
    }
    void dfs( List<List<String>> result , int start ,String s,boolean dp[][], List<String> currentList){
//         out of bound errors
        if(start >= s.length()){
            result.add(new ArrayList<String>(currentList));
        }
        for(int end=start; end < s.length();end++){
            if(s.charAt(start)==s.charAt(end) && (end-start <=2 || dp[start+1][end-1])){
                dp[start][end]=true;
                currentList.add(s.substring(start, end+1));
                dfs(result, end+1,s,dp,currentList);
                currentList.remove(currentList.size()-1);
            }
        }
//         bt
    }
}