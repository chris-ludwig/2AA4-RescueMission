package ca.mcmaster.se2aa4.island.teamXXX;

public class GPS {
    int x;
    int y;
    Direction direction;

    public GPS(Direction direction){
        this.direction = direction;
    }

    public int[] getPos(){
        return new int[]{x ,y};
    }
    public Direction getDirection(){
        return direction;
    }
}
