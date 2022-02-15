class Solution {
    boolean []visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        visited = new boolean[s.length()];
        Set<String> wordset = new HashSet<>();
        for(String word:wordDict){
            wordset.add(word);
        }
        return res(s,wordset,0);
    }
    
    private boolean res(String s, Set<String> set,int index){
        for(String word:set){
            if(s.equals(word))return true;
            else if(s.startsWith(word)){
                int len = word.length();
                if(visited[index+len])continue;
                if(res(s.substring(len),set,index+len))return true;
                visited[len+index]=true;
            }
        }
        return false;
    }
}