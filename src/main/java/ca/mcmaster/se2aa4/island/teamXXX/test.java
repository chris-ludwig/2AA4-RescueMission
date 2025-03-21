package ca.mcmaster.se2aa4.island.teamXXX;

public class test {
    public static void main(String args[]){
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        Direction n = Direction.WEST;
        System.out.println(n.toString());
        int[] a = n.toVector();
        System.out.println(a[0] + ", " + a[1]);
    }
}