import java.util.List;

public class BreadFirstSearch <T> {
    public void breadFirstSearch(Graph<T> graph) {
        //queue implementation
        NonResizableQueue<Vertex<T>> queue = new NonResizableQueue<>(graph.getSize());
        //visited vertexes
        boolean[] visited = new boolean[graph.getSize()];
        Vertex<T> v;
        //list of all vertexes
        List<Vertex<T>> vertexList = graph.getVertexList();
        queue.enqueue(vertexList.get(0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            v = queue.dequeue();
            //anything to do with vertex, for example printing its value
            System.out.println(v);
            for (int indexOfNextVertex : graph.getNeighbours(v)) {
                if(visited[indexOfNextVertex] == true)
                    continue;
                else {
                    queue.enqueue(vertexList.get(indexOfNextVertex));
                    visited[indexOfNextVertex] = true;
                }
            }
        }
    }
}
