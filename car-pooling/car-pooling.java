class Solution {
    public boolean carPooling1(int[][] trips, int capacity) {
//         for reference
        int lastlocation = -1;
        for(int trip[] : trips){
            lastlocation = Math.max(lastlocation, trip[2]);
        }
//         the array to store cummulative sum of passengers at any (distance ) instance
//         # 1 based indexing
        int route[] = new int [lastlocation +1];
        for(int trip[]:trips){
//             passengers sitting
            route[trip[1]] += trip[0];
//             passengers leaving
            route[trip[2]] -= trip[0];
        }
        for(int i=1; i<= lastlocation;i++){
            route[i]+=route[i-1];
//             if passengers surpass capactiy
            if(route[i] > capacity){
                return false;
            }
        }
        return true;
    }
    public boolean carPooling(int[][] trips, int capacity) {    
  int stops[] = new int[1001]; 
  for (int t[] : trips) {
      stops[t[1]] += t[0];
      stops[t[2]] -= t[0];
  }
  for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
  return capacity >= 0;
}
}