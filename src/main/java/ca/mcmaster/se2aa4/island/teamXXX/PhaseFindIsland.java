package ca.mcmaster.se2aa4.island.teamXXX;

public class PhaseFindIsland extends Phase {
    private int distance = 0;
    private Direction step = Direction.LEFT;//tracks which direction drone is echoing

    public PhaseFindIsland(Result knowledge){
        super(knowledge);
        state = State.FINDLAND;
    }

    //populates queue
    protected void makeDecision(){
        switch (state) {
            case State.FINDLAND:
                ResultEcho echoResult = (ResultEcho)knowledge;

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

            case State.MOVETOLAND:
                for(int i=0; i<distance; i++){
                    fly();
                }
                switchPhase("PhaseGridSearch");

            default:
                break;
        }
    }

    protected void onEnter(){//scan right immediately
        echo(Direction.RIGHT);
    }
}
