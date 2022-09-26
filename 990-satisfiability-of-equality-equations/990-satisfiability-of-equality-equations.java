class Solution {
    
    int parent[];
    int rank[];
    
    public boolean equationsPossible(String[] eqn) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        // add equals to same union
        for(String s:eqn){
            //if == add to union then
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        // add all to equal
        
        for(String s:eqn){
            if(s.charAt(1)=='!'){
                //then its parent should should not be same
                if(find(s.charAt(0)-'a')==find(s.charAt(3)-'a'))return false;
            }
        }
        return true;
    }
    
    private int find(int x){
        if(parent[x]==x)return x;
        int temp  = find(parent[x]);
        //path compression
        parent[x]=temp;
        return temp;
    }
    
    private void union(int x,int y){
        int px = find(x);
        int py = find(y);
        
        //if not same, if same then ignore
        if(px!=py){
            if(rank[px]>rank[py]){
                parent[py] = px;
            }else if(rank[px]<rank[py]){
                parent[px] = py;
            }else{
                parent[px] = py;
                rank[py]++;
            }
        }
    }
}