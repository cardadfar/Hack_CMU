// ADD TO GLOBAL BUS DATABASE

import java.util.ArrayList;

public class Driver {
    
    public String userName; 
    public ArrayList<String> IDs;
    
    public Driver(String name) {
        userName = name;
        IDs = new ArrayList<>();
    }
    public void addBus(String busID) {
        IDs.add(busID);
        // ADD TO GLOBAL BUS DATABASE
    }
}
