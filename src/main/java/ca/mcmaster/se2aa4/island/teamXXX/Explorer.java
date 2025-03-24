package ca.mcmaster.se2aa4.island.teamXXX;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    Drone drone;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}",info.toString(2));
        String direction = info.getString("heading");
        Integer batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
        drone = new Drone(batteryLevel, Direction.fromString(direction)); //initializes drone
    }

    @Override
    public String takeDecision() {
        JSONObject decision = new JSONObject();
        decision = drone.giveDecision();//gets decision from drone
        logger.info("** Decision: {}",decision.toString());
        return decision.toString();
    }

    @Override//will call acknowledgeresults from drone
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n"+response.toString(2));
        Integer cost = response.getInt("cost");
        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");
        logger.info("Additional information received: {}", extraInfo);

        //determining result type
        Result result;
        if(extraInfo.has("biomes")){
            result = new ResultScan(cost, status, extraInfo);
        }
        else if(extraInfo.has("range")){
            result = new ResultEcho(cost, status, extraInfo);
        }
        else{
            result = new Result(cost, status);
        }

        drone.acknowledgeResults(result);
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
