class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        Map<String, Integer> dp= new HashMap<>();
        for(String word:words){
            dp.put(word,1);
        }
        int max=0;
        for(String word: words){
//             //traverse in the length, all possible combinations
            for(int i=0;i<word.length();i++){
                String prev = word.substring(0,i)+ word.substring(i+1);// ignore the ith char
                if(dp.containsKey(prev)){
                    // increase chain length
                    dp.put(word,Math.max(dp.get(word), dp.get(prev)+1));
                }
            }
            
                max = Math.max(dp.get(word),max);
        }
        return max;
    }
}