package ca.mcmaster.se2aa4.island.teamXXX;

public class test {
    public static void main(String args[]){
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        Biome biome = Biome.valueOf("OCEAN");
        System.out.println(biome.toString());
        if(biome == Biome.OCEAN) System.out.println("yippeeeeee");
    }
}