class Solution {
    public int mirrorReflection(int p, int q) {
        int rooms = 1, rays = 0; 
        int dist = 0;
        while(dist % p != 0 || dist == 0){
            dist += q;
            rays++;
        }
        rooms = dist / p;
        if(rays % 2 == 1 && rooms % 2 == 0) return 0;
        else if(rays % 2 == 1 && rooms % 2 == 1) return 1;
        else return 2; 
    }
}