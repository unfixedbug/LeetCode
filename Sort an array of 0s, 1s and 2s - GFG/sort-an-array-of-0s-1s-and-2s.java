// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int nums[], int n)
    {
        // we have limited values , so we are using counting sort
        int pre[] = new int[3]; // 0,1,2
        int fin[] = new int[nums.length]; 
        
        // get their counts
        for(int i=0;i<nums.length;i++){
            pre[nums[i]]++;
        }
        // pre compute the array
        for(int i=1;i<pre.length;i++){
            pre[i]+=pre[i-1];
        }
        
        // create new array
        for(int i=0;i<nums.length;i++){
            fin[pre[nums[i]]-1] = nums[i];
            --pre[nums[i]];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = fin[i];
        }
        
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends