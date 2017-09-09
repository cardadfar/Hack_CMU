// QUERY ACTUAL DATABASE

import java.util.HashMap;

public class Passenger {
    
    public String userName;
    public HashMap<String, PassBus> Buses;
    
    public Passenger(String name) {
        userName = name;
        Buses = new HashMap<>();
    }
    
    // functions that require a bus ID
    public String getName(String b) {
        return Buses.get(b).getName();
    }
    public int getStopInd(String b) {
        return Buses.get(b).getStopInd();
    }
    public String getStopStr(String b) {
        return Buses.get(b).getStopName();
    }
    public boolean getResponse(String b) {
        return Buses.get(b).getResponse();
    }
    public void setResponse(String b, boolean resp) {
        Buses.get(b).setResponse(resp);
    }
    
    // Involves querying the actual database
    public int getCurrStopIndex() {
    }
    public String getCurrStopName() {
    
    }
}
