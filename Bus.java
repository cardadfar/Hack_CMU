import java.util.ArrayList;

public class Bus {
    
    public String ID;
    public String Name;
    public int currStopInd;
    public String currStopStr;
    public boolean routeTaken;
    public ArrayList<Stop> Stops;
    
    public Bus(String id, String name, String[] stops) {
        ID = id;
        Name = name;
        currStopInd = -1;
        currStopStr = "";
        routeTaken = false;
        
        Stops = new ArrayList<>();
        for (String stop : stops) {
            addStop(stop);
        }
    }
    private void addStop(String stop) {
        Stops.add(new Stop(stop));
    }
    
    public String getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public int getCurrStopInd() {
        return currStopInd;
    }
    public String getCurrStopStr() {
        return currStopStr;
    }
    public boolean getRouteTaken() {
        return routeTaken;
    }
    
    public void updateRouteTaken() {
        routeTaken = true;
    }
    
    // to be performed after route is finished
    public void reset() {} {
        currStopInd = -1;
        currStopStr = "";
        routeTaken = false;
        Stops.forEach((S) -> S.reset());
    }
    
    // Now for the Stop related functions
    public String getStopName(int s) {
        return Stops.get(s).getName();
    }
    public int getPassNum(int s) {
        return Stops.get(s).getPassNum();
    }
    public boolean getTaken(int s) {
        return Stops.get(s).getTaken();
    }
    public boolean getVoided(int s) {
        return Stops.get(s).getVoided();
    }
    
    public void updateCurrStop(int s) {
        currStopInd = s;
        currStopStr = Stops.get(s).getName();
    } 
    public void setTaken(int s) {
        Stops.get(s).updateTaken();
        updateCurrStop(s);
    }
    
    public void updatePassResp(int s, boolean resp, String pass) {
        Stops.get(s).updatePassResp(resp, pass);
    }
    public void addPass(int s, String pass) {
        Stops.get(s).addPass(pass);
    }
}