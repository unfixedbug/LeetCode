class Solution {
    
//         using bfs
    private String findLexSmallestString1(String s, int a, int b) {
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
    private String smallest;
    private int n;
    public String findLexSmallestString(String s, int a, int b) {
        smallest = s;
        n = s.length();
        dfs(s,a,b, new HashSet<>());
        return smallest;
    }
    private void dfs(String s, int a, int b, Set<String> seen){
        if(seen.add(s)){
            if(s.compareTo(smallest) <0 ){
                smallest = s;
            }
            char[] ca = s.toCharArray();
            
            for(int i=1;i<ca.length;i+=2){
                ca[i] = (char)((ca[i]-'0'+a)%10 + '0');
            }
            
            dfs(String.valueOf(ca),a,b,seen);
            dfs(s.substring(n-b) + s.substring(0,n-b),a ,b, seen);
        }
    }
    
   
}