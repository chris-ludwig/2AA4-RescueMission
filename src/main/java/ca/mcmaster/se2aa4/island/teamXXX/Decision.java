package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

public class Decision {
    private Direction direction;
    private String action;
    private String a = "action";
    
    public Decision(String action){
        this.action = action;
    }

    public Decision(String action, Direction direction){
        this.action = action;
        this.direction = direction;
    }

    //return decision as a JSONObject
    public JSONObject getDecision(){
        JSONObject decision = new JSONObject();
        decision.put(a, action);

        if(direction != null){
            decision.put("parameters", new JSONObject().put("direction", direction.toString()));
        }

        return decision;
    }
}
