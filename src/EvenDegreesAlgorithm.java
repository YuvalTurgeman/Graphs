public class EvenDegreesAlgorithm extends GraphAlgorithm {

    //constructor
    public EvenDegreesAlgorithm(Graph input){
        super(input);
    }

    //methods
    public Object runAlgorithm() {
        for (int v = 0; v < input.numberOfVertices(); v++)// v for vertices
            if (input.degree(v) % 2 != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {

        Graph g = new GraphAsAdjacencyMatrix(10);
        for(int i = 0; i < g.numberOfVertices(); i++)
            ((GraphAsAdjacencyMatrix)g).addEdge(i, (i+1)%g.numberOfVertices());
        //in the previous line we need to perform casting because Graph does not have the method
        //addEdge, only the classes that extends Graph have this method.

        System.out.println(g);

        GraphAlgorithm algo = new EvenDegreesAlgorithm(g);

        System.out.println (algo.runAlgorithm()); // true
        g.removeEdge(0, 1);
        System.out.println (algo.runAlgorithm()); // false
    }

}
