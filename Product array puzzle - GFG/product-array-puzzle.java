//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  


// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long ans=1;
        for(int e:nums){
            ans*=e;
        }
        long fins[] = new long[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0)fins[i] = sum(nums,i);
            // else if(ans==nums[i]){
            //     fins[i]=0;                
            // }
            else{
                fins[i] = ans/nums[i];
            }
                
        }
        return fins;
	} 

    private static long sum(int arr[], int pos){
        long ans=1;
        for(int i=0;i<arr.length;i++){
            if(ans==0)break;
            if(pos!=i)ans*=arr[i];
        }
        return ans;
    }
}


