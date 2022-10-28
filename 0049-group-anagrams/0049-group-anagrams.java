class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // will store string to index map
        HashMap<String, Integer > map  = new HashMap<>();
        List<List<String >> ans =new ArrayList<>();
        int i=0;
        for(String s:strs){
            char cur[] = s.toCharArray();
            Arrays.sort(cur);
            String now = new String(cur);
            if(!map.isEmpty() && map.containsKey(now)){
                ans.get(map.get(now)).add(s);
            }
            else{
                map.put(now,i);
                ans.add(new ArrayList<>());
                // add this string to new index
                ans.get(i++).add(s);
        
            }
        }
        return ans;
    }
    
}