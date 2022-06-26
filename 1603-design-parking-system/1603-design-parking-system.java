class ParkingSystem {
    int[] park;
    public ParkingSystem(int big, int medium, int small) {
        park = new int[4];
        park[1]=big;
        park[2]=medium;
        park[3]=small;
    }
    
    public boolean addCar(int carType) {
        if(park[carType]>0){
            park[carType]--;
            return true;
        }return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */