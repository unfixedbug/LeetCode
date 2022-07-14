// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int nums[], int n, int target) { 
    
      Map<Integer, Integer> map = new HashMap<>();
 
        // insert (element, index) pair into the map for each array element
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
 
        // consider each element except the last element
        for (int i = 0; i < nums.length - 1; i++)
        {
            // start from the i'th element until the last element
            for (int j = i + 1; j < nums.length; j++)
            {
                // remaining sum
                int val = target - (nums[i] + nums[j]);
 
                // if the remaining sum is found, we have found a triplet
                if (map.containsKey(val))
                {
                    // if the triplet doesn't overlap, return true
                    if (map.get(val) != i && map.get(val) != j) {
                        return true;
                    }
                }
            }
        }
 
        // return false if triplet doesn't exist
        return false;
    }
}
