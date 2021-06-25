public class GraphAsAdjacencyList implements Graph {

    //fields
    final private int nVertices;
    private List<List<Integer>> adj;

    //constructor
    public GraphAsAdjacencyList(int n){
        nVertices = n;
        adj = new LinkedList<List<Integer>>();
        for(int i = 0; i<nVertices; i++)
            adj.add(new LinkedList<Integer>(), 0);
    }

    //methods
    public int numberOfVertices() {
        return nVertices;
    }

    public int numberOfEdges() {
        return edgeSet().size();
    }

    @Override
    public boolean containsEdge(int i, int j) {
        return false;
    }

    @Override
    public void removeEdge(int i, int j) {

    }

    @Override
    public int degree(int v) {
        return 0;
    }

    @Override
    public Set<Integer> neighborsOf(int v) {
        return null;
    }

    @Override
    public Set<Edge> edgeSet() {
        return null;
    }
}
