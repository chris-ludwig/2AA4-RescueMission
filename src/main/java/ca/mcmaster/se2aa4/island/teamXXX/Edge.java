public class Edge {
    private Vertex origin;
    private Vertex destination;
    private Boolean isRiver;

    //constructor
    public Edge(Vertex origin, Vertex destination, Boolean isRiver){
        this.origin = origin;
        this.destination = destination;
        this.isRiver = isRiver;
    }
    //accessors
    public Vertex GetOrigin(){
        return origin;
    }
    public Vertex GetDestination(){
        return destination;
    }
    public Vertex[] GetVertices(){
        return new Vertex[] {origin, destination};
    }
    public Boolean IsRiver(){
        return isRiver;
    }
}