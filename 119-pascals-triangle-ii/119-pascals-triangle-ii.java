class Solution {
    List<List<Integer>> triangle;
    public List<Integer> getRow(int rowIndex) {
        return getRowRecursive(rowIndex);
    }
    private List<Integer> getRowRecursive(int rowIndex) {
        
        List<Integer> result = new ArrayList<>();
        
        if (rowIndex < 2) {
            result.add(1);    
            
            if (rowIndex == 1) {
                result.add(1);    
            }
            
            return result;
        }
//         else statement
            
        List<Integer> prev = getRowRecursive(rowIndex - 1);
        
        result.add(1);
        for (int i = 1; i < rowIndex; ++i) {
            result.add(prev.get(i - 1) + prev.get(i - 0));
        }
        result.add(1);
            
        return result;
    }
    
}