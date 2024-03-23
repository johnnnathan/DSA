import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<GraphNode> nodes = new ArrayList<>();

    public Graph(){}

    public void addNode(GraphNode node){
        nodes.add(node);
    }
    public void removeNode(int value){
        for (GraphNode node: nodes){
            if (node.getData() == value){
                nodes.remove(node);
            }
        }
    }
    public void drawGraph(){
        for (GraphNode node: nodes){
            for (GraphNode edge: node.getRelations()){
                System.out.println(node.getData() + " --> " + edge.getData());
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode(54);
        GraphNode node2 = new GraphNode(77);
        GraphNode node3 = new GraphNode(1);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        node1.addRelation(node2);
        node2.addRelation(node3);
        node1.addRelation(node3);
        graph.drawGraph();

    }
}
