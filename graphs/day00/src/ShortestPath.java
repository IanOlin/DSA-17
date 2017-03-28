import java.util.*;

public class ShortestPath {

    public static List<Integer> shortestPath(Graph g, int v, int w) {
        HashSet<Integer> checked = new HashSet();
        checked.add(v);

        Queue<Integer> toCheck = new LinkedList();
        toCheck.add(v);

        LinkedList path = new LinkedList();

        Map<Integer, Integer> paths = new HashMap<Integer, Integer>();
        int current = v;

        while(!toCheck.isEmpty()){
            current = toCheck.remove();
            if (current == w){
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

        if (current != w){
            return null;
        }
        for (int i = w; i !=v; i = paths.get(i)){
            path.addFirst(i);
        }

        path.addFirst(v);
        return path;

    }

    public static int distanceBetween(Graph g, int v, int w) {
        List path = shortestPath(g, v, w);
        if (path!=null){
            return path.size()-1;
        }
        return -1;
    }

}