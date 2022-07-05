class Solution {
    public String sortSentence(String s) {
        TreeMap<Integer,String> map = new TreeMap<>();
        // add each word in map;
        int start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                int index=s.charAt(i-1)-'1';
                String curr = s.substring(start,i-1);
                map.put(index,curr);
                start=i+1;
            }
        }
        // add last element to map
        int index=s.charAt(s.length()-1)-'1';
        String curr = s.substring(start,s.length()-1);
        map.put(index,curr);
        // traverse map and append to the string
        String ans="";
        for(Map.Entry<Integer, String> set:map.entrySet()){
            ans+= set.getValue();
            ans+=" ";
        }
        return ans.trim();
    }
}