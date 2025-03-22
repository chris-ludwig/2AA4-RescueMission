package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

public class ResultEcho extends Result{
    private boolean landHo;
    private int distance;

    public ResultEcho(JSONObject response){
        super(response);

        distance = response.getJSONObject("extras").getInt("range");
        if(response.getJSONObject("extras").getString("found").equals("GROUND")) landHo = true;
        else landHo = false;
    }

    public boolean groundFound(){
        return landHo;
    }

    public int getDistance(){
        return distance;
    }
}
