class Solution {
    Set<Integer> set;
    List<List<Integer>> rooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set = new HashSet<>();
        this.rooms =  rooms;
        set.add(0);
        takethisKey(0,rooms.get(0));
        if(set.size()==rooms.size())return true;
        return false;
    }
    
    private void takethisKey(int room, List<Integer> keys){
        for(int key:keys){
            if(!set.contains(key)){
                exploreRooms(key);
            }
        }
    }
    private void exploreRooms(int room){
        set.add(room);
        takethisKey(room,rooms.get(room));
    }
}