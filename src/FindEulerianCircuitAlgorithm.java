import java.util.LinkedList;public class FindEulerianCircuitAlgorithm extends GraphAlgorithm {    private GraphAlgorithm hasEulerianCircuitAlgorithm;    //constructor    public FindEulerianCircuitAlgorithm(Graph input){        super(input);        hasEulerianCircuitAlgorithm = new HasEulerianCircuitAlgorithm(input);    }    //methods    public Object runAlgorithm(){        if(!(Boolean)hasEulerianCircuitAlgorithm.runAlgorithm())            return null;        LinkedList<Integer> circuit = new LinkedList<Integer>();        Graph copy = new GraphAsAdjacencyMatrix(input);        findEulerianCircuit(0, copy, circuit);        return circuit;    }    private void findEulerianCircuit(int curr, Graph graph, LinkedList<Integer> circuit){        while(graph.neighborsOf(curr).size() != 0) {            Iterator<Integer> iter = graph.neighborsOf(curr).iterator();            int next = iter.next();            graph.removeEdge(curr, next);            findEulerianCircuit(next, graph, circuit);        }        circuit.addFirst(curr);    }}