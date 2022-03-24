class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j=people.length-1;
        int boats=0;
        while(i<=j){
            if(people[j] == limit){
                j--;
                boats++;
            }else{
                if(people[j]+people[i]<=limit){
                    i++;
                    j--;
                    boats++;
                }else{
                    j--;
                    boats++;
                }
            }
        }
        return boats;
    }
}