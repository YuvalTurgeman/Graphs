public class GraphAsAdjacencyMatrix extends AbstractGraph{

    //fields
    private boolean [][] edges;

    //constructor
    public GraphAsAdjacencyMatrix(int n){
        super(n);
        edges = new boolean [n][n];
        for(int i=0;i<edges.length;i++)
            for(int j = 0;j<edges[i].length; j++)
                edges[i][j] = false;
    }

    //copy constructor
    public GraphAsAdjacencyMatrix(Graph other){
        this(other.numberOfVertices());
        for(int i=0;i < other.numberOfVertices();i++)
            for(int j = i+1;j < other.numberOfVertices(); j++)
                if(other.containsEdge(i, j))
                    addEdge(i, j);
    }

    //methods
    public void addEdge(int i, int j){
        if(!rangeCheck(i,j))
            throw new IllegalArgumentException();
        edges[i][j] = true;
        edges[j][i] = true;
    }

    public boolean containsEdge(int i, int j) {
        if(!rangeCheck(i,j))
            throw new IllegalArgumentException();
        return edges[i][j];
    }


    public void removeEdge(int i, int j) {
        if(!rangeCheck(i,j))
            throw new IllegalArgumentException();
        edges[i][j] = false;
        edges[j][i] = false;
    }

}
