import java.util.ArrayList;
public class HashMapImplementation {
  private int size;
  private HashMapList[] lists;
  public HashMapImplementation(int size){
    this.size = size;
    this.lists = new HashMapList[size];
    for (int i = 0; i < size; i++){
      this.lists[i] = new HashMapList();
    }
    
  }

  public static void main(String[] args) {
    HashMapImplementation map = new HashMapImplementation(10);
    map.put(new HashMapNode("John", 20));
    map.put(new HashMapNode("olive" , 17));
    map.put(new HashMapNode("ilove", 22));
    map.visualize();
  }
  public void put(HashMapNode node){
    int pos = findHashValue(node.getKey());
    lists[pos].add(node);
  }
  public void visualize() {
    for (int i = 0; i < size; i++) {
      System.out.print("Bucket " + i + ": ");
      if (lists[i] != null) {
        HashMapList currentList = lists[i];
        ArrayList<HashMapNode> nodeList = currentList.getNodes();
        for (HashMapNode node : nodeList) {
          System.out.print("(" + node.getKey() + ", " + node.getValue() + ") ");
        }
      }
      System.out.println();
    }
  }



  public int findHashValue(String key){
    char[] chars = key.toCharArray();
    int sum = 0;
    for(int i = 0; i < chars.length; i++){
      sum += chars[i];
    }
    return sum % this.size;
  }


}

