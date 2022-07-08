// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        return kthSmallestt(arr,l,r,k);
       
    } 
    
    static int kthSmallestt(int arr[], int l, int r, int k) {
    // k is smaller than =length of array
        if (k > 0 && k <= r - l + 1) {
          // gives index of the pivot element, whose left is sorted, right is sorted
          int pos = randomPartition(arr, l, r);
    
          // if the current position is the kth position, return the element
          if (pos - l == k - 1) return arr[pos];
    
          // if [l ... k...pos ..r]
          // number of elements in left subarray is greater than k, k lies between left subarray
          if (pos - l > k - 1) {
            return kthSmallestt(arr, l, pos - 1, k);
          }
          // recur right side of array with, relative k position
          return kthSmallestt(arr, pos + 1, r, k - (pos - l) - 1);
          // if [l ...pos...k....r]
        }
        return -1;
  }

  // partition the array around the pivot element
  // first get random element between l,r and make it pivot
  // move it to the end of the array
  // then partition the array around the pivot element

  static int randomPartition(int arr[], int l, int r) {
    // get number between l,r
    int random = getPivot(arr, l, r);
    // move pivot to the end of the array
    swap(arr, random, r);
    // partition the array around the pivot element
    int pivot = arr[r]; // which is actually the last element of the array, we set as pivot
    int pIndex = l;
    for (int i = l; i < r; i++) {
      if (arr[i] <= pivot) {
        swap(arr, i, pIndex);
        pIndex++;
      }
    }
    swap(arr, pIndex, r);
    return pIndex;
  }

  static int getPivot(int arr[], int l, int r) {
    // get number between l,r
    int lengthOfWindow = r - l + 1;
    int randomNumber = (int) (Math.random() * (lengthOfWindow - 1));
    return l + randomNumber;
  }

  static void swap(int arr[], int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }
}
