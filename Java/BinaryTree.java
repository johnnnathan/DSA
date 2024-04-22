public class BinaryTree {
  public BinaryTreeNode root;

  public BinaryTree(){}

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.addNode(tree.root,new BinaryTreeNode(5));
    tree.addNode(tree.root, new BinaryTreeNode(3));
    tree.addNode(tree.root, new BinaryTreeNode(7));
    tree.addNode(tree.root, new BinaryTreeNode(1));
    tree.addNode(tree.root, new BinaryTreeNode(2));
    tree.addNode(tree.root, new BinaryTreeNode(10));
    tree.addNode(tree.root, new BinaryTreeNode(4));
    tree.addNode(tree.root, new BinaryTreeNode(6));
    tree.inorderTraversal(tree.root);
    System.out.println();
    tree.deleteNode(null, tree.root, 3);
    tree.inorderTraversal(tree.root);
  }
  public void addNode(BinaryTreeNode currentNode, BinaryTreeNode node){
    if (emptyTree()){
      root = node;
      System.out.print(", Created Root");
      return;
    }
    if (currentNode == null){
      return;
    }
    
    if (node.getData() < currentNode.getData() && currentNode.hasLeft()){
      addNode(currentNode.getLeft(),node);
    }
    else if(node.getData() < currentNode.getData() && !currentNode.hasLeft()){
      currentNode.setLeft(node);
      return;
    }
    else if(node.getData() > currentNode.getData() && currentNode.hasRight()){
      addNode(currentNode.getRight(), node);
    }
    else if (node.getData() > currentNode.getData() && !currentNode.hasRight()){
      currentNode.setRight(node);
      return;
    }
    else{
      System.out.println("Error adding element, possibly exists already inside tree.");
      return;
    }
    return;
    }
    

  public void deleteNode(BinaryTreeNode parent, BinaryTreeNode currentNode,int data){
    if (emptyTree()){
      return;
    }

    char childStatus = currentNode.hasSingleChild();
    int currentData = currentNode.getData();
    if (data < currentNode.getData()){
      deleteNode(currentNode, currentNode.getLeft(),data);
    }
    else if (data > currentNode.getData()){
      deleteNode(currentNode, currentNode.getRight(), data);
    }
    else{
      if (currentNode.isLeaf()){
        if (parent.getLeft().getData() == currentData){parent.setLeft(null);}
        if (parent.getRight().getData() == currentData) {parent.setRight(null);}
        currentNode = null;
        return;
      }
      else if (childStatus == 'L'){
        if (parent != null) {
          if (parent.getLeft() == currentNode) {
            parent.setLeft(currentNode.getLeft());
          } else {
            parent.setRight(currentNode.getLeft());
          }
        } else {
          root = currentNode.getLeft(); // If parent is null, currentNode is root
        }
      }
      else if (childStatus == 'R'){
        if (parent != null) {
          if (parent.getLeft() == currentNode) {
            parent.setLeft(currentNode.getRight());
          } else {
            parent.setRight(currentNode.getRight());
          }
        } else {
          root = currentNode.getRight(); // If parent is null, currentNode is root
        }
      }
      else if (childStatus == 'B'){
        int min = currentNode.getRight().findMin();
        deleteNode(currentNode, currentNode.getRight(), min); // Delete the node with min value
        currentNode.setData(min); // Replace the current node data with min value
      }
      


      
    }
  }
  public void search(BinaryTreeNode node, int data){
    if (emptyTree()){
      return;
    }
    if (node.isLeaf()){
      System.out.println("Node not in Tree");
    }
    if (data < node.getData() && node.hasLeft()){
      search(node.getLeft(), data);
    }
    else if (data > node.getData() && node.hasRight()){
      search(node.getRight(), data);
    }
    else if (data == node.getData()){
      System.out.println("Node in tree");
    }
    else{
      System.out.println("ERROR");
    }
  }


        

  public boolean emptyTree(){
    if (root == null){
      System.out.println("Empty tree");
      return true;
    }
    return false;
  
  }

  public void preorderTraversal(BinaryTreeNode node){
    if (emptyTree()){
      return;
    }
    if (node == null){return;}
    System.out.print(node.getData());
    if (node.hasLeft()){
      System.out.print("->");
      preorderTraversal(node.getLeft());
    }
    if (node.hasRight()){
      System.out.print("->");
      preorderTraversal(node.getRight());
    }
    return;
  } 
  public void inorderTraversal(BinaryTreeNode node){
    if (emptyTree()){
      return;
    }

    if (node.hasLeft()){
      inorderTraversal(node.getLeft());
    }
    System.out.print(node.getData() + "->");
    if (node.hasRight()){
      inorderTraversal(node.getRight());
    }
    return;

  }
  public void postorderTraversal(BinaryTreeNode node){
    if (emptyTree()){
      return;
    }
    if (node.hasLeft()){
      inorderTraversal(node.getLeft());
    }
    if (node.hasRight()){
      inorderTraversal(node.getRight());
    }
    System.out.print(node.getData() + "->");

    return;
  }

}

 
