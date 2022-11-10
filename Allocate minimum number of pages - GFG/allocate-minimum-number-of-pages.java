//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]books,int n,int students)
    {
        //Your code here
        if(students>n)return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        int res = -1;
        for (int e : books) {
          low = Math.max(low, e);
          high += e;
        }
    
        //the search over pages
        while (low <= high) {
          int mid = (low + high) >> 1;
          if (canAllocate(books, mid, students)) {
            //okay this might be the possible answer now, search for a smaller answer
            res = mid;
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        return res;
        
    }
    
    //divide array a in m parts such that maximum sum of numbers in part is minimum
    private static boolean canAllocate(int books[], int max, int students) {
    int allocatedStudents = 1;
    //pages allocated to last student
    int pages = 0;
    for (int i = 0; i < books.length; i++) {
      if (max < books[i]) return false;
      if (pages + books[i] > max) {
        pages = books[i];
        allocatedStudents++;
      } else {
        pages += books[i];
      }
    }
    if (allocatedStudents > students) return false;

    return true;
  }
};