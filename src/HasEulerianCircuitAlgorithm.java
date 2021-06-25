public class HasEulerianCircuitAlgorithm extends GraphAlgorithm{
    //fields
    private GraphAlgorithm evenDegrees;
    private GraphAlgorithm connectivity;

    //constructor
    public HasEulerianCircuitAlgorithm(Graph input){
        super(input);
        evenDegrees = new EvenDegreesAlgorithm(input);
        connectivity = new ConnectivityAlgorithm(input);
    }

    //methods
    public Object runAlgorithm(){
        return (Boolean) evenDegrees.runAlgorithm() && (Boolean) connectivity.runAlgorithm();
    }


    public static void main(String[] args) {
        Graph g = new GraphAsAdjacencyMatrix(8) ;
        ((GraphAsAdjacencyMatrix) g).addEdge(0,1);
        ((GraphAsAdjacencyMatrix) g).addEdge(1,2);
        ((GraphAsAdjacencyMatrix) g).addEdge(2,3);
        ((GraphAsAdjacencyMatrix) g).addEdge(3,1);
        ((GraphAsAdjacencyMatrix) g).addEdge(1,7);
        ((GraphAsAdjacencyMatrix) g).addEdge(7,4);
        ((GraphAsAdjacencyMatrix) g).addEdge(4,6);
        ((GraphAsAdjacencyMatrix) g).addEdge(6,5);
        ((GraphAsAdjacencyMatrix) g).addEdge(5,4);
        ((GraphAsAdjacencyMatrix) g).addEdge(4,0);

        System.out.println(g);

        GraphAlgorithm hasEulerAlgo = new HasEulerianCircuitAlgorithm(g);
        System.out.println(hasEulerAlgo.runAlgorithm()); // true
    }

}
