import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  private int data;
  private List<GraphNode> relations = new ArrayList<>();

  public GraphNode(int value){
    this.data = value;
  }
  public List<GraphNode> getRelations(){
    return this.relations;
  }
  public void addRelation(GraphNode node){
    relations.add(node);
  }
  public void removeRelation(int value){
    for (GraphNode node: relations){
      if (node.getData() == value){
        relations.remove(node);
      }
    }
  }
  public int getData(){
    return this.data;
  }
}
