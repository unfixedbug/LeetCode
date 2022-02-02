class Solution {
    public List<Integer> findAnagrams(String s, String p) {

       
       ArrayList<Integer> soln = new ArrayList<Integer>();
       
       if (s.length() == 0 || p.length() == 0 || s.length() < p.length()){
           return new ArrayList<Integer>();
       }
       
       int[] chars = new int[26];
       for (Character c : p.toCharArray()){
           chars[c-'a']++;
       }
       
       int start = 0, end = 0, len = p.length(), diff = len;
       
       char temp;
       for (end = 0; end < len; end++){
           temp = s.charAt(end);
           
           chars[temp-'a']--;
           
           if (chars[temp-'a'] >= 0){
               diff--;
           }
       }
       
       if (diff == 0){
           soln.add(0);
       }
       
       while (end < s.length()){
           temp = s.charAt(start);
           
           if (chars[temp-'a'] >= 0){
               diff++;
           }
           
           chars[temp-'a']++;
           
           //Increment start to start shifting the window over by 1
           start++;
           
           //Temp represents the last character of the window, the "new" character from the window shift.
           //This character "replaces" the one we removed before so the window stays the same length (p.length())
           temp = s.charAt(end);
           
           //Decrement hash value for this character, because it is now a part of the window
           chars[temp-'a']--;
           
           //Again, if it's not negative it is part of the anagram. So decrement diff
           if (chars[temp-'a'] >= 0){
               diff--;
           }
           
           if (diff == 0){
               soln.add(start);
           }
           
           end++;
           
       }
       
       return soln;
    }
}