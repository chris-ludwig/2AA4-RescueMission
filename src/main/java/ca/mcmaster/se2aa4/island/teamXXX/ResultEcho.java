package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

//holds the results of echo actions
public class ResultEcho extends Result{
    private boolean landHo;
    private int distance;

    //copy cost, status, if land is found and distance into structure
    public ResultEcho(int cost, String status, JSONObject response){
        super(cost, status);

        distance = response.getInt("range");
        if(response.getString("found").equals("GROUND")) landHo = true;
        else landHo = false;
    }

    public boolean groundFound(){
        return landHo;
    }

    public int getDistance(){
        return distance;
    }
}
