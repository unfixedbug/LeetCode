// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends





// https://www.youtube.com/watch?v=LjPx4wQaRIs
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (Job p1, Job p2) -> Integer.compare(p2.profit, p1.profit)); // sorts array oin decreasing order or-> sort(arr,(a, b) -> b.profit - a.profit)
        
        int maxdeadline=0;;
        for(Job job:arr){
            if(job.deadline>maxdeadline)maxdeadline = job.deadline;
        
            
        }
        
        // array with deadlines , we also put job id in that
        int occupied[] = new int[maxdeadline+1];
        
        Arrays.fill(occupied,-1);
        int profit=0,countJobs=0;
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){// traverse through all deadlines, if available spot inorder to do the work
                if(occupied[j]==-1){// slot is empty ie, not occupied we can do the task now
                    occupied[j] = arr[i].id;
                    countJobs++;
                    profit+=arr[i].profit;
                    break;
                    
                }
            }
        }
        
        return new int[]{countJobs,profit};
        
        //get array with max deadlines length
            
    }
}
        

