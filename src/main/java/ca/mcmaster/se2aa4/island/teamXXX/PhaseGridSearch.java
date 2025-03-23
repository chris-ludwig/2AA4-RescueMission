package ca.mcmaster.se2aa4.island.teamXXX;

 //starts by scanning area
//continues to fly and scan strip of land until ocean is reached
//check if land is still ahead, if so continue to fly, if not find edge of strip of land beside drone
//turn right(left) and scan left(right) once edge has been found, if more land in initial direction, turn back and continue looking for edge
//if not more land in intial direction make a tight/wide turn depending on distance, then move to land and repeat
public class PhaseGridSearch extends Phase{
    private Direction direction;
    private int distance;
    ResultScan scanResult;
    ResultEcho echoResult;

    public PhaseGridSearch(Direction direction){
        super();
        this.direction = direction;
    }

       protected void makeDecision(){
        switch(state) {
            case State.INITIAL://scan to start cycle
                scan();
                switchState(State.OVERLAND);
                break;

            case State.OVERLAND://after scanning, check biomes and if ocean found echo forward and switch states or fly and scan
                scanResult = (ResultScan)result;
                boolean oceanFound = false;
                for(Biome biome: scanResult.getBiomes()){//checking for ocean
                    if(biome == Biome.OCEAN) oceanFound = true;
                }
                if(oceanFound){//send echo and switch
                    echo(Direction.FORWARD);
                    switchState(State.INTERPRETECHO);
                }
                else{//fly and scan
                    fly();
                    scan();
                }
                break;
            
            case State.INTERPRETECHO://switch to MOVETOLAND if land found, switch to FINDEDGE if not
                echoResult = (ResultEcho)result;
                if(echoResult.groundFound()){
                    distance = echoResult.getDistance();
                    switchState(State.MOVETOLAND);
                }
                else{
                    echo(direction);
                    switchState(State.FINDEDGE);
                }
            case State.MOVETOLAND://fly to land and then scan once reached, switch to OVERLAND
                for(int i=0; i<=distance; i++){
                    fly();
                }
                switchState(State.OVERLAND);
                scan();
                break;
            
            case State.FINDEDGE://fly until no more land is directly beside drone, turn onto new strip and check for land
                echoResult = (ResultEcho)result;
                if(echoResult.groundFound() && echoResult.getDistance() == 0){//edge not found
                    fly();
                    echo(direction);
                }
                else{//turn onto strip and echo for ground in initial direction
                    turn(direction);
                    echo(direction.opposite());
                    switchState(State.MOVETOLAND2);
                }
                break;

            case State.MOVETOLAND2://turn and move towards land in initial direction, going back to finding the edge otherwise look for land in other direction
                echoResult = (ResultEcho)result;
                if(echoResult.groundFound()){//more ground in initial direction
                    if(echoResult.getDistance() > 1){//ground far
                        turn(direction.opposite());
                        turn(direction.opposite());
                        turn(direction);
                        for(int i=0; i<=echoResult.getDistance()-3; i++){//fly until land is beside drone
                            fly();
                        }
                    }
                    else{//ground close, tight turn
                        turn(direction);
                        turn(direction);
                        turn(direction);
                        for(int i=0; i<=echoResult.getDistance()+1; i++){//fly until land is beside drone
                            fly();
                        }
                    }
                    echo(direction);
                    switchState(State.FINDEDGE);
                }
                else{//just more ocean in initial direction
                    echo(direction);//check for land in other direction
                    switchState(State.FINDLAND);
                }

            case State.FINDLAND://look for land on this strip, and if found fly to it, if not cease mission
                echoResult = (ResultEcho)result;
                if(echoResult.groundFound()){
                    tightTurn(direction);
                    for(int i=0; i<=echoResult.getDistance(); i++){
                        fly();
                    }
                    scan();
                    direction = direction.opposite();
                    switchState(State.OVERLAND);
                }
                else{//no more land, entire island has been searched
                    decisions.add(new Decision("stop"));
                }

            default:
                break;

        }
    }
}
