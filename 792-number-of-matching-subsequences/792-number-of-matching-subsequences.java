class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String tea:words){
            map.put(tea,map.getOrDefault(tea,0)+1);
        }
        int res=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(issubsequence(s,entry.getKey())){
                res+=entry.getValue();
            }
        }
        return res;
    }
    
    private boolean issubsequence(String s, String tocheck){
        int scur=0;
        int tocheckcur=0;
        if(tocheck.length()>s.length())return false;
        while(scur<s.length()&&tocheckcur<tocheck.length()){
            if(tocheck.charAt(tocheckcur)==s.charAt(scur))tocheckcur++;
            scur++;
        }
        return tocheckcur==tocheck.length();
    }
}