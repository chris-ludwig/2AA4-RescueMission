public class Vertex {
    //xy coordinates of the vertex
    private float x;
    private float y;

    //constructors
    public Vertex(float x, float y){
        this.x = x;
        this.y = x;
    }
    public Vertex(){
        Vertex(0,0);
    }

    //accessors
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float[] getCoords(){
        return new float[] {x,y};
    }
}