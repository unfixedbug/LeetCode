//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        return (long)(partition(arr1,arr2,k));
        
    }
    
    //the binary search
    private int partition(int a[], int b[], int k){
        if(b.length<a.length){
            //swap a and b
            return partition(b,a,k);
        }
        // need k elements to the left
        int n1=a.length;
        int n2=b.length; 
        
        //edge cases
        int low=Math.max(0,k-n2);
        
        int high=Math.min(k,n1);
        
        while(low<=high){
            int cut1 = (low+high)>>1; // mid
            int cut2 = k-cut1;
            
            int left1 = cut1==0?Integer.MIN_VALUE:a[cut1-1];
            int left2 = cut2==0?Integer.MIN_VALUE:b[cut2-1];
            
            int right1 = cut1==n1?Integer.MAX_VALUE:a[cut1];
            int right2 = cut2==n2?Integer.MAX_VALUE:b[cut2];
            
            //if we have the correct position
            
            if(left1 <= right2 && left2 <=right1){
                return Math.max(left1,left2);
            }else if(left1 > right2){
                high=cut1-1;
            }else{
                low=cut1+1;
            }
        }
        return 0;
        
    }
}