package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

//holds all information necessary to create a JSONObject to send actions to drone
//can convert to JSONObject
//can apply turns such as left and right to cardinal directions
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

    //apply the left/right turn to the drones position from the command
    public void applyTurn(Direction direction){
        if(this.direction == null) return;//decision is undirected
        
        int[] directionVector = direction.toVector();
        if(this.direction == Direction.LEFT  && directionVector[0] == 0 || this.direction == Direction.RIGHT && directionVector[0] != 0){
            int temp = directionVector[0];
            directionVector[0] = directionVector[1];
            directionVector[1] = temp;
        }
        else if(this.direction == Direction.LEFT && directionVector[0] != 0 || this.direction == Direction.RIGHT && directionVector[0] == 0){
            int temp = -directionVector[0];
            directionVector[0] = -directionVector[1];
            directionVector[1] = temp;
        }
        this.direction = Direction.fromVector(directionVector);
    }   

    public String getAction(){
        return action;
    }

    public Direction getDirection(){
        return direction;
    }

    //return decision as a JSONObject
    public JSONObject getJSONObject(){
        //create json object with action
        JSONObject decision = new JSONObject();
        decision.put(a, action);

        if(direction != null){//add direction parameter if necessary
            decision.put("parameters", new JSONObject().put("direction", direction.toString()));
        }

        return decision;
    }
}
