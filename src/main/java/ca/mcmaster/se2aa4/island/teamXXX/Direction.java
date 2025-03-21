package ca.mcmaster.se2aa4.island.teamXXX;

enum Direction{
    NORTH,
    EAST,
    SOUTH,
    WEST,
    LEFT,
    RIGHT,
    FORWARD;

    @Override
    public String toString(){
        if(this == Direction.NORTH) return "N";
        else if(this == Direction.EAST) return "E";
        else if(this == Direction.SOUTH) return "S";
        else if(this == Direction.WEST) return "W";
        else if(this == Direction.LEFT) return "L";
        else if(this == Direction.RIGHT) return "R";
        else return "F";
    }

    public int[] toVector(){
        if(this == Direction.NORTH) return new int[]{0, -1};
        else if(this == Direction.EAST) return new int[]{1, 0};
        else if(this == Direction.SOUTH) return new int[]{0, 1};
        else if(this == Direction.WEST) return new int[]{-1, 0};
        else return null;
    }

    public Direction opposite(){
        if(this == Direction.NORTH) return Direction.SOUTH;
        else if(this == Direction.EAST) return Direction.WEST;
        else if(this == Direction.SOUTH) return Direction.NORTH;
        else if(this == Direction.WEST) return Direction.EAST;
        else if(this == Direction.LEFT) return Direction.RIGHT;
        else if(this == Direction.RIGHT) return Direction.LEFT;
        else return null;
    }
}