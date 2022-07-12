// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends


class Solution{
    static int minJumps(int[] nums){
        // your code here
        int currFar = 0, jumps = 0, curend = 0;
    
    if(nums.length==1)return 0;
    if (nums[0] == 0)
            return -1;
    int steps=nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
        // if we raeach last index
        if(i==nums.length-1)return jumps;
      currFar = Math.max(currFar, i + nums[i]);
    //   step--;
      
    //   if(step==0){
          
    //   }
      if (i == curend) {
        jumps++;
        curend = currFar;
        if (curend >= nums.length - 1) return jumps;
      }
    }
    return -1;
    }
}