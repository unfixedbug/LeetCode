// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        int []r = new int[n];
        int l[] = new int[n];
        int msf = price[0];
        int mxsf = price[n-1];
        //left array
        for(int i=1;i<n;i++){
            if(price[i]<msf){
                msf = price[i];
            }
            int curprof = price[i]-msf;
            if(l[i-1]<curprof){
                l[i] = curprof;
            }else{
                l[i] = l[i-1];
            }
        }
        
        // now compute profit for 
        for(int i=n-2;i>=0;i--){
            if(price[i]>mxsf){
                mxsf=price[i];
            }
            int curprof = mxsf-price[i];
            if(r[i+1]<curprof){
                r[i] = curprof;
            }else{
                r[i] = r[i+1];
            }
        }
        
        //final calclatio
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,l[i]+r[i]);
        }
        return ans;
    }
}
        
