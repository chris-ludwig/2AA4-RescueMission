package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

//holds the results of actions which return a cost and status
public class Result {
    protected Integer cost;
    protected boolean status;

    //copy cost and status into structure
    public Result(int cost, String status){
        this.cost = cost;
        this.status = status.equals("OK");
    }

    public int getCost(){
        return cost;
    }

    public boolean isOK(){
        return status;
    }
} 
