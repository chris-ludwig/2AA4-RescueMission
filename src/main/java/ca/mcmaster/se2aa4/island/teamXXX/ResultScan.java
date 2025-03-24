package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;
import org.json.JSONArray;

//unsure of how biomes and creeks are returned in the result, need to look into that
//holds the result of scan action
public class ResultScan extends Result{
    public Biome[] biomes;

    //copy cost, status, and array of biomes into structure
    public ResultScan(int cost, String status, JSONObject extras){
        super(cost, status);

        JSONArray biomeArray = extras.getJSONArray("biomes");
        biomes = new Biome[biomeArray.length()];

        for(int i=0; i<biomeArray.length(); i++){
            biomes[i] = Biome.valueOf(biomeArray.getString(i));
        }
    }

    public Biome[] getBiomes(){
        return biomes;
    }
}