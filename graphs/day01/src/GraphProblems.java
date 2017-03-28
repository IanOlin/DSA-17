import java.util.*;

public class GraphProblems {

    public static boolean connected(Graph g, int v, int u) {
        HashSet<Integer> checked = new HashSet();
        checked.add(v);

        Queue<Integer> toCheck = new LinkedList();
        toCheck.add(v);

        LinkedList path = new LinkedList();

        Map<Integer, Integer> paths = new HashMap<Integer, Integer>();
        int current = v;

        while(!toCheck.isEmpty()){
            current = toCheck.remove();
            if (current == u){
                break;
            }
            else {
                for (int vertex : g.getNeighbors(current)) {
                    if (!checked.contains(vertex)){
                        toCheck.add(vertex);
                        checked.add(vertex);
                        paths.put(vertex, current);
                    }
                }
            }
        }

        if (current != u){
            return false;
        }
        return true;
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        Stack s = new Stack();
        List res = new LinkedList();
        Boolean visited[] = new Boolean[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++) {
            visited[i] =false;
        }
        for (int j = 0; j < g.numVertices(); j++) {
            if (!visited[j]){
                topoSortHelper(j, g, visited, s);
            }
        }

        while(!s.isEmpty()){
            res.add(s.pop());
        }
        return res;
    }

    public static void topoSortHelper(int v, Digraph g, Boolean visited[],Stack s){
        visited[v] = true;
        int current;

        Iterator toSort = g.getNeighbors(v).iterator();

        while (toSort.hasNext()){
            current = (int) toSort.next();
            if (!visited[current]) {
                topoSortHelper(current, g, visited, s);
            }
        }

        s.push(v);
    }

    public static boolean hasCycle(UndirectedGraph g) {
        Boolean visited[] = new Boolean[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++) {
            visited[i] =false;
        }
        for (int j = 0; j < g.numVertices(); j++) {
            if (!visited[j]){
                if (hasCycleHelper(j, g, visited, -1))
                    return true;
            }
        }
        return false;
    }

    public static boolean hasCycleHelper(int v, UndirectedGraph g, Boolean visited[], int parent){
        Iterator toCheck = g.getNeighbors(v).iterator();
        visited[v] = true;
        int current;

        while(toCheck.hasNext()){
            current = (int) toCheck.next();

            if (!visited[current]) {
                if (hasCycleHelper(current, g, visited, v)){
                    return true;
                }
            }
            else if (current != parent){
                return true;
            }
        }
        return false;
    }

}