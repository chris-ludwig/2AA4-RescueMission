package ca.mcmaster.se2aa4.island.teamXXX;

public class PhaseFindIsland extends Phase {
    private int distance;
    private Direction step = Direction.LEFT;//tracks which direction drone is echoing

    public PhaseFindIsland(){
        super();
    }

    //populates queue
    protected void makeDecision(){
        switch (state) {
            case State.INITIAL:
                echo(Direction.RIGHT);
            case State.FINDLAND:
                ResultEcho echoResult = (ResultEcho)result;

                if(echoResult.groundFound()){//ground found, turn and switch states
                    distance = echoResult.getDistance();

                    if (distance < 2){//tight turn if ground is close, wide if not
                        tightTurn(step.opposite());
                    }
                    else{
                        wideTurn(step.opposite());
                        distance -= 2;
                    }
                    switchState(State.MOVETOLAND);
                }
                else{//ground not found, fly forward and echo
                    if(step == Direction.LEFT) fly();
                    echo(step);
                    step = step.opposite();
                }

                break;

            case State.MOVETOLAND://fly forward until land is reached and switch phases
                for(int i=0; i<distance; i++){
                    fly();
                }
                switchPhase("PhaseGridSearch");
                break;
                
            default:
                break;
        }
    }
}
