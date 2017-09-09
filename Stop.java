import java.util.HashMap;

// Stop object
public class Stop {
    
    public String Name; // stop name
    public int passNum; // number of passengers, NOT affected by passenger updates
    public int passGoing; // number of passengers going, affected by passenger updates
    public boolean taken; // is false if passed
    public boolean voided; // is true if no people
    public HashMap<String, Boolean> response; // stores passenger's responses
    
    public Stop(String name) {
        Name = name;
        passNum = 0; 
        passGoing = 0;
        taken = false; 
        voided = true;
        response = new HashMap<>();
    }
    
    // resets all the variables once the route is complete
    public void reset() {
        passGoing = passNum;
        taken = false;
        if (passNum == 0) voided = true;
        else voided = false;
        
        for (String pass : response.keySet()) {
            response.put(pass, true); // everyone defaults to going
        }
    }
    public String getName() {
        return Name;
    }
    public int getPassNum() {
        return passNum;
    }
    public boolean getTaken() {
        return taken;
    }
    public boolean getVoided() {
        return voided;
    }
    
    public void updateTaken() {
        taken = false;
    }
    public void updatePassResp(boolean resp, String pass) {
        response.put(pass, resp);
        if (resp) passGoing++;
        else passGoing--;
        
        // change voided if needed
        if (passGoing == 0) voided = true;
        else voided = false;
    }
    public void addPass(String pass) {
        response.put(pass, true);
        passNum++;
        passGoing++;
    }
}
