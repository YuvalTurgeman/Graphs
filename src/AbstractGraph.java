public abstract class AbstractGraph implements Graph {

    //fields
    final protected int nVertices;

    //constructor
    public AbstractGraph(int n){
        if(n <= 0)
            throw new IllegalArgumentException();
        nVertices = n;
    }

    //methods
    public int numberOfVertices() {
        return nVertices;
    }

    public int numberOfEdges(){
        return edgeSet().size();
    }

    public int degree(int v){
        if(!rangeCheck(v))
            throw new IllegalArgumentException();
        return neighborsOf(v).size();
    }

    public Set<Edge> edgeSet(){
        Set<Edge> edges = new SetAsDynamicArray<>();
        for(int i = 0;i<numberOfVertices();i++)
            for(int j = i+1;j<numberOfVertices();j++)
                if(containsEdge(i,j))
                    edges.add(new Edge(i,j));
        return edges;
    }

    public Set<Integer> neighborsOf(int v){
        Set<Integer> neighbors = new SetAsDynamicArray<>();
        Iterator<Edge> edgeIterator = edgeSet().iterator();
        while(edgeIterator.hasNext()) {
            Edge e = edgeIterator.next();
            if (e.left == v)
                neighbors.add(e.right);
            else if (e.right == v)
                neighbors.add(e.left);
        }
        return neighbors;
    }

    //returns true iff i and j are vertices
    protected boolean rangeCheck(int i, int j){
        return rangeCheck(i) && rangeCheck(j);
    }

    //returns true iff i is a vertex
    protected boolean rangeCheck(int i){
        return i >= 0 && i<nVertices;
    }

    public String toString(){
        return edgeSet().toString();
    }

    public boolean equals(Object other){
        if(!(other instanceof AbstractGraph))
            return false;
        return nVertices == ((AbstractGraph)other).nVertices &&
                edgeSet().equals(((AbstractGraph)other).edgeSet());
    }

    //abstract methods
    public abstract boolean containsEdge(int i, int j);

    public abstract void addEdge(int i, int j);

    public abstract void removeEdge(int i, int j);

}
