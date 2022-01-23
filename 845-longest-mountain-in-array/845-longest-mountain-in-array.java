class Solution {
    public int longestMountain(int[] arr) {
        int res=0;
        int n=arr.length;
        
//         traverse 
        for(int i=1;i<n;i++){
            int count=1;
            boolean flag=false;
            //start from the previous ended position
            int j=i;
            //increasing seq
            while(j<n && arr[j]>arr[j-1]){
                j++;
                count++;
                
            }
            while(i!=j && j<n && arr[j]<arr[j-1]){
                j++;
                flag=true;
                count++;
            }
            // at least some work and
            if(flag&&i!=j &&  count>2){
                res = Math.max(res,count);
                j--;
                
            }
            i=j;
        }
        return res;
    }
}