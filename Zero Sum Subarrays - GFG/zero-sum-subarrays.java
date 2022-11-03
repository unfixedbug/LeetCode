//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long, Integer> freq = new HashMap<>();
        long pre = 0;
        long ans=0;
        
        freq.put(pre,1);
        for(int i=0;i<n;i++){
            pre +=arr[i];
            if(freq.containsKey(pre)){
                ans+=freq.get(pre);
                freq.put(pre,freq.get(pre)+1);
            }else{
                freq.put(pre,1);
            }
        }
        return ans;
    }
}