class Solution {
    public String frequencySort(String s) {
        int cnt[] = new int [128];
        for(char ch:s.toCharArray())cnt[ch]++;
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b)-> cnt[b]-cnt[a]);
        for(int i='a';i<='z';i++) if(cnt[i]>0)maxheap.offer((char)i);
        for(int i='A';i<='Z';i++) if(cnt[i]>0)maxheap.offer((char)i);
        for(int i='0';i<='9';i++) if(cnt[i]>0)maxheap.offer((char)i);
        StringBuilder sb = new StringBuilder();
        while(!maxheap.isEmpty()){
            char cur = maxheap.poll();
            sb.append(String.valueOf(cur).repeat(cnt[cur]));
        }
        
        return sb.toString();
        
}}