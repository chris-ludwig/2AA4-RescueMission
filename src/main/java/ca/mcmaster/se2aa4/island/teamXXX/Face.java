public class Face {
    private Edge[] edges;
    private float[] center = {0,0};

    public Face(Edge[] edges, Biome biome){
        this.edges = edges;
        this.biome = biome;

        for(i=0; i<edges.size; i++){
            center[0] += edges[i].GetOrigin().GetX();
            center[1] += edges[i].GetOrigin().GetY();
        }
        center[0] /= edges.size;
        center[1] /= edges.size;
    }

}