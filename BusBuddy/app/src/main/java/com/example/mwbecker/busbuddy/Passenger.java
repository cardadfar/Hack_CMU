package com.example.mwbecker.busbuddy;

// QUERY ACTUAL DATABASE

import java.util.HashMap;

public class Passenger {
    
    public String userName;
    public HashMap<String, PassBus> Buses;
    
    public Passenger(String name) {
        userName = name;
        Buses = new HashMap<>();
    }

    public int getNumBuses() { return Buses.size(); }

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
    public void addBus(String b, int s) {
        Bus B = BB[b]; //FIX for name
        PassBus pb = new PassBus(b, B.getName(), s, B.getStopName(s));
        Buses.put(b, pb);
    }
    
    // Involves querying the actual database
    public int getCurrStopIndex(String b) {
        return 0;
    }
    public String getCurrStopName(String b) {
        return "";
    }
}