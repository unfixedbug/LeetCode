class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ay2-ay1)*(ax2-ax1);
        int areaB = (bx2-bx1)*(by2-by1);
        
        
        //x overlap
        int left = Math.max(ax1,bx1);
        int right = Math.min(ax2,bx2);
        
        int xoverlap = right-left;
        
        // yoverlap
        int top = Math.min(ay2,by2);
        int bottom = Math.max(ay1,by1);
        
        int yoverlap = top-bottom;
        
        int overlappedarea=0;
        if(xoverlap >0 && yoverlap>0){
            overlappedarea = xoverlap*yoverlap;
        }
        
        return areaA+areaB-overlappedarea;
    }
}