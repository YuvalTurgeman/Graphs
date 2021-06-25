public class ConnectivityAlgorithm extends GraphAlgorithm {

    public ConnectivityAlgorithm(Graph input){
        super(input);
    }

    public Object runAlgorithm(){
        int nVertices = input.numberOfVertices();
        boolean [] visited = new boolean[nVertices];
        for(int i=0;i<nVertices;i++)
            visited[i] = false;
        dfsVisit(0,visited);
        return reachedAll(visited);
    }

    private void dfsVisit(int i, boolean[] visited){
        visited[i] = true;
        Iterator<Integer> neighborsIterator = input.neighborsOf(i).iterator();
        while(neighborsIterator.hasNext()) {
            Integer neighbor = neighborsIterator.next();
            if (!visited[neighbor])
                dfsVisit(neighbor, visited);
        }
    }

    private boolean reachedAll(boolean[] visited){
        for(boolean b: visited)
            if(!b)
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

        GraphAlgorithm algo = new ConnectivityAlgorithm(g);

        System.out.println (algo.runAlgorithm()); // true
        g.removeEdge(0, 1);
        System.out.println (algo.runAlgorithm()); // true
        g.removeEdge(1, 2);
        System.out.println (algo.runAlgorithm()); // false
    }

}
