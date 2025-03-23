package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

//unsure of how biomes and creeks are returned in the result, need to look into that
//holds the result of scan action
public class ResultScan extends Result{

    public ResultScan(int cost, String status, JSONObject result){
        super(cost, status);


    }

    public Biome[] getBiomes(){
        return new Biome[]{Biome.OCEAN};
    }

    public Boolean getCreeks(){
        return false;
    }
}