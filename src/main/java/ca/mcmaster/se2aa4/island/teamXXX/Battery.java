package ca.mcmaster.se2aa4.island.teamXXX;

//stores battery information and checks for if battery is too low to continue
public class Battery {
    private int charge;

    public Battery(int charge){
        this.charge = charge;
    }

    public void drain(int charge){
        this.charge -= charge;
    }

    public int getCharge(){
        return charge;
    }
    public boolean isLow(){
        return charge < 30;
    }
}
