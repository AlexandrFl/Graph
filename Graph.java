public class Graph {
    private int[] size;

    public Graph(int[] size) {
        this.size = size;
    }

    public void addEdge(int a, int b) {
        size[a] = b;
        size[b] = a;
    }

    public int adjacent(int a) {
        return size[a];
    }
}

