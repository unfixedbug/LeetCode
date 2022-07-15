// { Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  //add code here.
                  for(int el:a){
                      if(ispalin(el)==false)return 0;
                  }
                  return 1;
           }
           
           private static boolean ispalin(int n){
               StringBuilder sb = new StringBuilder();
               sb.append(n+"");
               String rev = sb.toString();
               return rev.equals(sb.reverse().toString());
           }
}