package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

//stores necessary information for the drone
//holds what phase its in to change drone logic
//provides way for explorer to interact with phases and get drones actions
public class Drone {
    private Battery battery;
    private GPS gps;
    private Phase phase = new PhaseFindIsland();

    public Drone(int charge, Direction direction) {
        this.battery = new Battery(charge);
        this.gps = new GPS(direction);
    }

    public JSONObject giveDecision(){//give next action
        if(battery.isLow()){//stop mission if battery is too low to continue
            JSONObject stop = new JSONObject();
            stop.put("action", "stop");
            return stop;
        }
        //get decision from the phase
        Decision decision = phase.getDecision();

        //if decision is to switch phases do so and get new decision
        if(decision.getAction().equals("PhaseFindIsland")){
             phase = new PhaseFindIsland();
             decision = phase.getDecision();
        }
        else if(decision.getAction().equals("PhaseGridSearch")){
            phase = new PhaseGridSearch(decision.getDirection());
            decision = phase.getDecision();
        } 
        //apply turn and return decision as JSONObject
        decision.applyTurn(gps.getDirection());
        return decision.getJSONObject();
    }

    public void acknowledgeResults(Result result){//send results to phase to make next decision
        phase.acknowledge(result);
    }
}
