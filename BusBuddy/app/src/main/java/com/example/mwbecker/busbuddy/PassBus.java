package com.example.mwbecker.busbuddy;

public class PassBus {
    public String ID;
    public String Name;
    public int stopInd;
    public String stopName;
    public boolean Resp;
    public PassBus(String id, String name, int s, String sn) {
        ID = id;
        Name = name;
        stopInd = s;
        stopName = sn;
        Resp = true;
    }
    public boolean getResponse() {
        return Resp;
    }
    public void setResponse(boolean r) {
        Resp = r;
    }
    public String getName() {
        return Name;
    }
    public int getStopInd() {
        return stopInd;
    }
    public String getStopName() {
        return stopName;
    }
}

