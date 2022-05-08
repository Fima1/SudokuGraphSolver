import java.text.CollationElementIterator;
import java.util.*;

public class Graph{

    private final String[] colors = {"none", "red", "orange", "yellow", "green", "blue", "purple", "pink", "cyan", "magenta"};
    private final ArrayList<String> COLORS = new ArrayList<>(Arrays.asList(colors));

    private Map<Integer, Node> vertices = new HashMap<Integer, Node>(); // Map<ids, Nodes>

    public class Node{
        private int id;
        private String color;
        private ArrayList<Integer> neighbors;

        Node(int id, String color, ArrayList<Integer> neighbors){
            if(!COLORS.contains(color)){
                throw new IllegalArgumentException();
            }
            this.id = id;
            this.color = color;
            this.neighbors = neighbors;
        }

        Node(int id){
            this(id, "none", new ArrayList<Integer>());
        }

        public void setColor(String color){
            this.color = color;
        }

        public String getColor(){
            return color;
        }

        public List<Integer> getNeighbors(){
            return neighbors;
        }
    }


    public void addVertex(int id, Node vertex){
        vertices.putIfAbsent(id, vertex);
    }

    public void addById(int id){
        Node v = new Node(id);
        vertices.putIfAbsent(id, v);

    }

    public void addAllByID(int[] ids){
        for(int id: ids){
            this.addById(id);
        }
    }

    public Node getVertex(int id){
        return vertices.get(id);
    }

    public void removeVertex(int id){
        vertices.remove(id);
    }

    public void addEdge(int source, int destination){
        vertices.get(source).neighbors.add(destination);
        vertices.get(destination).neighbors.add(source);
    }

    public void removeEdge(int source, int destination){
        vertices.get(source).neighbors.remove(destination);
        vertices.get(destination).neighbors.remove(source);
    }

    public Map<Integer, Node> getVertices(){
        return vertices;
    }

    public void printVertices(){
        Collection<Node> allV = vertices.values();
        for(Node v: allV){
            System.out.println(v.id + " --> " + v.neighbors.toString());
        }
    }

    public static void main(String[] args){
        Graph g = new Graph();

        for(int i = 0; i < 6; i++){
            g.addById(i);
        }

        g.addEdge(0, 1);
        g.addEdge(0,5);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,0);
        g.addEdge(5,4);
        g.addEdge(5,2);

        g.printVertices();
    }

}