class Solution {
    
//         using bfs
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String smallest = s;
        Queue<String> q = new LinkedList<>();
        
        q.offer(s);
        
        Set<String> seen = new HashSet<>();
        
        while( !q.isEmpty()){
            String cur = q.poll();
            
//             if cur is lexicographically smaller than 'smallest' (string)
            if(cur.compareTo(smallest) < 0 ){
                smallest = cur;
            }
            char []ca = cur.toCharArray();
            
//             using add operation
            for(int i=1; i< ca.length;i+=2){
                ca[i] = (char)((ca[i]- '0' + a )%10 + '0');
            }
            String addA = String.valueOf(ca); // char array to string;
            // if unique, then add to seen set and queue
            if(seen.add(addA)){
                q.offer(addA);
            }
            
//             using the rotate operation
            
            String rotate = cur.substring(n-b) + cur.substring(0,n-b);
            if(seen.add(rotate)){
                q.offer(rotate);
            }
        }
        return smallest;
    }
    
    
//using dfs
//     public String findLexSmallestString1(String s, int a, int b) {
        
//     }
    
   
}