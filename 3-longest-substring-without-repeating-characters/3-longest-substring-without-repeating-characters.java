class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int ans=0;
        HashSet<Character> set = new HashSet<>(); // will contain all the unique charcters
        while(end<s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                ans = Math.max(set.size(),ans);
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return ans;
    }
}