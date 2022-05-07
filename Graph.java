import java.util.*;

public class Graph{

    private final String[] COLORS = {"none", "red", "orange", "yellow", "green", "blue", "purple", "pink", "cyan", "magenta"};

    private class Node{
        private int id;
        private int color;
        private ArrayList<Integer> neighbors;

        Node(int id, int color, ArrayList<Integer> neighbors){
            this.id = id;
            this.color = color;
            this.neighbors = neighbors;
        }

        Node(int id){
            this(id, -1, new ArrayList<Integer>());
        }


        public void setColor(int color){
            
        }

        public boolean addNeighbor(Node neighbor){
            return false;
        }
    }

}