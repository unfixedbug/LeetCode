//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String isSumOfTwo(int n){
        // code here
        boolean primes[] = sieve(n);
                
        
        for(int i=1;i<n;i++){
            if(primes[i]==true && primes[n-i]==true){
                
            // System.out.println(i+" "+(n-i));
                return "Yes";}
        }
        
        return "No";
    }
    
   
    
    private static boolean[] sieve(int n){
        boolean primes[] = new boolean[n+1];
        Arrays.fill(primes,true);
        
        primes[0]=false;
        primes[1]=false;
        
        for(int i=2;i*i<=n;i++){
            if(primes[i]==true){
                for(int j=i*i;j<=n;j+=i){
                    primes[j]=false;
                }
            }
        }
        return primes;       
    }
}