class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int []count = {0,0};
        int n= students.length,k;
        for(int e: students){
            count[e]++;
        }
        for(k=0; k<n && count[sandwiches[k]]>0 ; k++){
            count[sandwiches[k]]--;
        }
        return n-k;
    }
}