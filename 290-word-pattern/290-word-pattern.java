class Solution {
    public boolean wordPattern(String pattern, String s) {
        String st[] = s.split(" ") ;
        if(st.length != pattern.length()) return false;
        Map map = new HashMap(); 
        for(Integer i=0;i<st.length;i++){
            if(map.put(pattern.charAt(i),i) != map.put(st[i],i)){
                return false;
            }
        }
        return true;
    }
}