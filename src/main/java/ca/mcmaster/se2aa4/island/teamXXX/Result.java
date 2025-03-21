package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

public class Result {
    protected Integer cost;
    protected boolean status;

    public Result(JSONObject response){
        this.cost = response.getInt("cost");
        if(response.getString("status") != "OK") status = true;
        else status = false;
    }

    public int getCost(){
        return cost;
    }

    public boolean isOK(){
        return status;
    }
} 
