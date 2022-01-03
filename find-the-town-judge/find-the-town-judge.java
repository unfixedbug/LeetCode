class Solution {
    public int findJudge(int n, int[][] trust) {
        int indeg[] = new int [n];
        boolean out[] = new boolean[n];
        for(int[] a:trust){
            indeg[a[1]-1]++;
            out[a[0]-1] = true; 
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==n-1 && out[i]==false){
                return i+1;
            }    
        }
        return -1;
    }
}