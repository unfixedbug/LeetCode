class Solution {
    public int characterReplacement(String s, int k) {
//         maxf frequency of element with most frequency
        int maxf = 0, n=s.length(), fre[] = new int[26];        
        int start=0;
        
        int maxlength=0;
        
        for(int end=0 ; end<n ; end++){
            fre[s.charAt(end)-'A']++;
            maxf = Math.max(maxf, fre[s.charAt(end)-'A']); // get the max frequency
            
            // number of characters to be changed =  window length - maxf +1, the element well change
            while(end - start - maxf + 1 > k){
                // pop the character from front window
                fre[s.charAt(start)-'A']--;
                start++;
            }
            maxlength = Math.max(maxlength, end-start+1);
        }
        return maxlength;
    }
}