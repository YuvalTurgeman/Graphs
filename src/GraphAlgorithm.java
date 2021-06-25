public abstract class GraphAlgorithm {
    //fields
    protected Graph input;

    //constructor
    public GraphAlgorithm(Graph g){
        input = g;
    }

    //methods
    public abstract Object runAlgorithm();
}
