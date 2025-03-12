public enum Biome {
    BEACH,
    LAKE,
    MANGROVE,
    OCEAN,
    SHRUBLAND,
    TROPICAL_FOREST,
    TROPICAL_SAVANNAH;

    public static Biome fromString(String biome){
        if(biome == "BEA") return BEACH;
        else if(biome == "LAK") return LAKE;
        else if(biome == "MAN") return MANGROVE;
        else if(biome == "OCE") return OCEAN;
        else if(biome == "SHR") return SHRUBLAND;
        else if(biome == "trF") return TROPICAL_FOREST;
        else if(biome == "trS") return TROPICAL_SAVANNAH;
        else return null;
    }
}