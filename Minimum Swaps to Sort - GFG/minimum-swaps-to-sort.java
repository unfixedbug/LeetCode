//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code hereas
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            if(vis[i] || map.get(nums[i])==i){//correct position
                continue;// no cycle formed
            }
            int j=i,cycle_size=0;
            while(!vis[j]){
                vis[j]=true;
                j=map.get(nums[j]);
                cycle_size++;
            }
            if(cycle_size>0)ans+=cycle_size-1;
            
        }
        return ans;
    }
}