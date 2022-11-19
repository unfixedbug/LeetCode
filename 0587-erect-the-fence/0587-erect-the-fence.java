class Solution {
    public int[][] outerTrees(int[][] trees) {
        if(trees.length <= 3) 
           return trees;
        Arrays.sort(trees, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
        }
    });
     
        List<int[]> lower = new ArrayList<>();
        List<int[]> upper = new ArrayList<>();
        
        for(int[] tree: trees) {
            while(lower.size() >= 2 && compare(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) > 0) {
                lower.remove(lower.size() - 1);
            }
            
            while(upper.size() >= 2 && compare(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
                upper.remove(upper.size() - 1);
            }
            
            lower.add(tree);
            upper.add(tree);
        }
        
        Set<int[]> set = new HashSet<>();
        for(int[] l : lower) {
            set.add(l);
        }
        
        for(int[] u : upper) {
            set.add(u);
        }
        
        int[][] result = new int[set.size()][2];
        
        int index = 0;
        for(int[] s: set) {
            result[index++] = s;
        }
        
        return result;
    }
    
    // < 0: clockwise
    // > 0: counterclockwise
    // == 0 : collinear
    private int compare(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0];
        int y1 = p1[1];
        int x2 = p2[0];
        int y2 = p2[1];
        int x3 = p3[0];
        int y3 = p3[1];
        
        return (y3 - y2) * (x2 - x1) - (y2 - y1) * (x3 - x2);
    }   
}