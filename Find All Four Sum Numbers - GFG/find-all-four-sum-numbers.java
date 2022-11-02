//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        
        // op list
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        if(arr==null || arr.length==0)return op;
        int n=arr.length;
        
        //jump over the duplicates [remember]
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
            int t3 = k-arr[i];
            for(int j=i+1;j<n;j++){
                int t2 = t3-arr[j];
                
                // now apply binary search between j and last element
                int front = j+1;
                int back = n-1;
                
                while(front<back){
                    int twosum = arr[front]+arr[back];
                    if(twosum<t2){
                        //increase sum, so increase left pointer
                        front++;
                    }
                    else if(twosum>t2){
                        back--;
                    }
                    else{// we have the quadruple
                    
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        
                        op.add(quad);
                        //processing the duplicates
                        // shift the front pointer untill same element is shifted , 3rd number duplicate
                        while(front<back && arr[front]==quad.get(2))front++;
                        
                        //skippiing duplicates from end , 4rth number duplicate
                        while(front<back && arr[back]==quad.get(3))back--;
                
                    }
                }
                
                //process the duplicate of 2nd number
                while(j+1 <n && arr[j+1]==arr[j])j++;
            }
            //process duplicate of first number
            while(i+1<n&& arr[i+1]==arr[i])i++;
        }
        
        return op;
    }
}