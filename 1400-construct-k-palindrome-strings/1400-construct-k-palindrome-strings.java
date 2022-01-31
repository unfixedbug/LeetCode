class Solution {
    public boolean canConstruct(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        if(s.length()<k)return false;
        for(char c: s.toCharArray()){
            if(freq.containsKey(c)){
                freq.put(c,freq.get(c)+1);
            }else{
                freq.put(c,1);
            }
        }
        int odd=0;
        for(Map.Entry<Character, Integer> set: freq.entrySet()){
            if(set.getValue()%2==1)odd++;
        }
        if(odd>k)return false;
        return true;
    }
}