import java.util.*;

public class UndirectedGraph implements Graph {
    HashMap<Integer, LinkedList<Integer>> graph;
    List<Integer> vertices;
    int numVertices;
    int numEdges;

    public UndirectedGraph(int n) {
        graph = new HashMap<Integer, LinkedList<Integer>>();
        vertices = new ArrayList<Integer>();
        numEdges = 0;
        numVertices = n;
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<Integer>());
            vertices.add(i);
        }
    }

    @Override
    public void addEdge(int v, int w) {
        //O(1)
        graph.get(v).add(w);
        graph.get(w).add(v);
        numEdges++;
    }

    @Override
    public List<Integer> vertices() {
        //O(1)
    	return vertices;
    }

    @Override
    public int numVertices() {
        //O(1)
        return numVertices;
    }

    @Override
    public int numEdges() {
    	//O(1)
        return numEdges;
    }

    @Override
    public Iterable<Integer> getNeighbors(int v) {
        //O(1)
    	return graph.get(v);
    }

    @Override
    public boolean hasEdgeBetween(int v, int w) {
    	if (graph.get(v).contains(w)){
    	    return true;
        }
        return false;
    }

}
