import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int vertices = 6;

    public static void main(String[] args) {
        int[] size = new int[vertices];
        Graph graph = new Graph(size);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        calcPaths(graph);
    }

    public static int dfs(int v, int mark, int[] marks, Graph graph) {
        marks[v] = mark;
        int size = 1;
        int nextV = graph.adjacent(v);
        if (marks[nextV] == 0) {
            size += dfs(nextV, mark, marks, graph);
        }
        return size;
    }

    public static void calcPaths(Graph graph) {
        int[] marks = new int[vertices];
        int[] answer = new int[vertices];
        List<Integer> markSizes = new ArrayList<>();
        markSizes.add(0);
        for (int i = 0; i < vertices; i++) {
            if (marks[i] == 0) {
                int nextMark = markSizes.size();
                int size = dfs(i, nextMark, marks, graph);
                markSizes.add(size);
            }
            for (int j = 0; j < vertices; j++) {
                answer[i] = markSizes.get(marks[i]) - 1;
            }
        }
        System.out.println("Сколько достижимо городов для каждого города: " + Arrays.toString(answer));
    }
}




