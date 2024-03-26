import java.util.ArrayList;

public class HashMapList {
    private ArrayList<HashMapNode> hashList;

    public HashMapList() {
        hashList = new ArrayList<>();
    }

    public void add(HashMapNode node){
      hashList.add(node);
    }
    public void remove(HashMapNode node){
      hashList.remove(node);
    }
  public ArrayList<HashMapNode> getNodes() {
    return hashList;
  }


}
