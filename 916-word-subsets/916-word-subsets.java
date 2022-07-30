class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // / count of letter should be greater than its total maximuym occurance in all strings in b
        int maxreq[] = new int[26];
        for(String b:words2){
            // will freq array for b string
            int currCount[] = count(b);
            // set maxrequired
            for(int i=0;i<26;i++){
                maxreq[i] = Math.max(maxreq[i],currCount[i]);
            }
        }
        
        
        List<String >res = new ArrayList<>();
        
        next: for(String a:words1){
            int aCount[] = count(a);
            for(int i=0;i<26;i++){
                // if current has less elements than required
                if(aCount[i]<maxreq[i]){
                    continue next; // coninute next string
                }
            }
            // else add the current
            res.add(a);
        }
        return res;
        
    }
    
    private int[] count(String s){
        int freq[] = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}