// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class mycomparator implements Comparator<meeting>{
    @Override
    public int compare (meeting o1,meeting o2){
        if(o1.end<o2.end)return -1;
        else if(o1.end>o2.end)return 1;//
        return 0;//same
        
    }
}
class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos){
        this.start= start;
        this.end = end;
        this.pos = pos;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> meets = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meets.add(new meeting(start[i],end[i],i));
        }
        
        ArrayList<Integer> m  = new ArrayList<>();
        mycomparator mc = new mycomparator();
        Collections.sort(meets,mc);
        int time_limit = meets.get(0).end;
        m.add(meets.get(0).pos);
        
        
        for(int i=1;i<start.length;i++){
            if(meets.get(i).start>time_limit){
                m.add(meets.get(i).pos);
                time_limit = meets.get(i).end; // occupied till end
                
            }
        }
        return m.size();
    }
}
