package ca.mcmaster.se2aa4.island.teamXXX;

enum Direction{
    NORTH,
    EAST,
    SOUTH,
    WEST;

    @Override
    public String toString(){
        if(this == Direction.NORTH) return "N";
        else if(this == Direction.EAST) return "E";
        else if(this == Direction.SOUTH) return "S";
        else return "W";
    }

    public int[] toVector(){
        if(this == Direction.NORTH) return new int[]{0, -1};
        else if(this == Direction.EAST) return new int[]{1, 0};
        else if(this == Direction.SOUTH) return new int[]{0, 1};
        else return new int[]{-1, 0};
    }
}