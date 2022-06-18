class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hashmap that maches string with index?
        HashMap<String, Integer> map  = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int i=0;
        for(String s: strs){
            StringBuilder sb = new StringBuilder();
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            for(char e:ch){
                sb.append(e);
            }
            String nsf = sb.toString();
            if(!map.isEmpty()&&map.containsKey(nsf)){
                ans.get(map.get(nsf)).add(s);
            }else{
                map.put(nsf,i);
                ans.add(new ArrayList<>());
                ans.get(i++).add(s);
            }
        }
        return ans;
        //
    }
}