class UndergroundSystem {
    class passenger{
        public int id;
        public String stationName;
        public int time;
        
        public passenger(int id, String stationName, int time){
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    class route{
        public double total = 0;
        public int count = 0;
        
        public void update(int difference){
            count++;
            total += difference;
        }
        public double getAvg(){
            return total / count;
        }
    }
    
    public Map<Integer, passenger> passengersArrivals;
    public Map<String, route> routeAverage;

    public UndergroundSystem() {
        passengersArrivals = new HashMap<>();
        routeAverage = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passengersArrivals.put(id, new passenger(id, stationName, t));
    }
    
    public final String DELIMETER = ",";
    
    public void checkOut(int id, String stationName, int t) {
        passenger arrivePassenger = passengersArrivals.get(id);
        passengersArrivals.remove(id);
        
        int difference = t - arrivePassenger.time;
        String key = arrivePassenger.stationName + DELIMETER + stationName;
        
        route average = routeAverage.containsKey(key) ? routeAverage.get(key) : new route();
        average.update(difference);
        
        routeAverage.put(key, average);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + DELIMETER + endStation;
        return routeAverage.get(key).getAvg();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */