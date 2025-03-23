package ca.mcmaster.se2aa4.island.teamXXX;

import java.util.LinkedList;
import java.util.Queue;

//defines basic movements for the drone, a queue to store a set of moves.
public abstract class Phase {
    protected Queue<Decision> decisions = new LinkedList<>();
    protected State state;
    protected Result result;

    public Phase(){
        state = State.INITIAL;
    }

    public void acknowledge(Result result){
        this.result = result;
    }

    protected void fly(){
        decisions.add(new Decision("fly"));
    }

    protected void turn(Direction dir){//basic heading change
        decisions.add(new Decision("heading", dir));
    }
    protected void tightTurn(Direction dir){//change direction without changing position
        fly();
        turn(dir.opposite());
        turn(dir.opposite());
        turn(dir.opposite());
        fly();
    }
    protected void wideTurn(Direction dir){//turning while remaining on the same x/y axis(needs two squares of space)
        fly();
        turn(dir);
        turn(dir);
        turn(dir.opposite());
    }

    protected void scan(){//scan ground below
        decisions.add(new Decision("scan"));
    }
    protected void echo(Direction dir){//echo in front, left, or right
        decisions.add(new Decision("echo", dir));
    }

    protected void switchState(State state){
        this.state = state;
    }
    protected void switchPhase(String phase){
        decisions.add(new Decision(phase));
    }
    protected void switchPhase(String phase, Direction direction){
        decisions.add(new Decision(phase, direction));
    }
    public State getState(){
        return state;
    }

    //get decision off queue
    public Decision getDecision(){
        if(decisions.isEmpty()) makeDecision();
        return decisions.remove();
    }
    protected abstract void makeDecision();
}
