class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            int count = map.getOrDefault(c,0)+1; // incremented count
            if(count > (s.length()+1)/2) return ""; // count is 1 greater than half of the string
            map.put(c,count); // put the updated count
        }
        
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->b[1]-a[1]);// decreasing order, a[1]-b[1] would have been increasing
        for(char c:map.keySet()){
            pq.add(new int[]{c,map.get(c)});// append char and its frequency in the priority queue
        }
        
        StringBuilder sb =new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            // handle the first element case
            if(sb.length()==0 || first[0] != sb.charAt(sb.length()-1)){// if characters are diffrent , prev and now
                sb.append((char)first[0]);// add to ans
                if(--first[1]>0){// decrease the count
                    pq.add(first); // put the next iteration for the queue, because count is not 0 
                }
            }
            else{// 
                int[]second = pq.poll();
                sb.append((char)second[0]);
                if(--second[1]>0){ // decrrease the count adnd add to the queue for second iteration
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}