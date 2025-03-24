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

    public static Direction fromString(String string){
        if(string.equals("N")) return Direction.NORTH;
        else if(string.equals("E")) return Direction.EAST;
        else if(string.equals("S")) return Direction.SOUTH;
        else if(string.equals("W")) return Direction.WEST;
        else if(string.equals("L")) return Direction.LEFT;
        else if(string.equals("R")) return Direction.RIGHT;
        else if(string.equals("F")) return Direction.FORWARD;
        else return null;
    }

    public int[] toVector(){
        if(this == Direction.NORTH) return new int[]{0, -1};
        else if(this == Direction.EAST) return new int[]{1, 0};
        else if(this == Direction.SOUTH) return new int[]{0, 1};
        else if(this == Direction.WEST) return new int[]{-1, 0};
        else return null;
    }

    public static Direction fromVector(int[] vector) {
        if (vector[0] == 0 && vector[1] == -1) return Direction.NORTH;
        else if (vector[0] == 1 && vector[1] == 0) return Direction.EAST;
        else if (vector[0] == 0 && vector[1] == 1) return Direction.SOUTH;
        else if (vector[0] == -1 && vector[1] == 0) return Direction.WEST;
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