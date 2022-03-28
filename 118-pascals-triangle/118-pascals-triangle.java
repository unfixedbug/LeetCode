class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        tri.add(row);
        for(int i=1;i<numRows;i++){
            List<Integer> prev = tri.get(i-1);
            row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prev.get(j-1)+ prev.get(j));
            }
            row.add(1);
            tri.add(row);
        }
        return tri;
        
    }
}