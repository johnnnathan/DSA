public class BinaryTreeNode {
  private BinaryTreeNode rightChild;
  private BinaryTreeNode leftChild; 
  private int data; 

  public BinaryTreeNode(int value){
    this.data = value;
    this.rightChild = null;
    this.leftChild = null;
  }

  public void setRight(BinaryTreeNode node){
    this.rightChild = node;
  }
  public void setLeft(BinaryTreeNode node){
    this.leftChild = node;
  }
  public BinaryTreeNode getRight(){return this.rightChild;}
  public BinaryTreeNode getLeft(){return this.leftChild;}
  public int getData(){return this.data;}
  
  public boolean hasRight(){
    if (rightChild == null){
      return false;
    }
    return true;
  }
  public boolean hasLeft(){
    if (leftChild == null){
      return false;
    }
    return true;
  }
  public boolean isLeaf(){
    if ((hasLeft() || hasRight())){
      return false;
    }
    return true;
  }
  public char hasSingleChild(){
    if ((hasLeft() && !hasRight())){
      return 'L';
    }
    else if (hasRight() && !hasLeft()){
      return 'R';
    }
    else if (hasRight() && hasLeft()){
      return 'B';
    }
    return 'N';
  }
  public int findMin(){
    BinaryTreeNode currentNode = this;
    while (currentNode.hasLeft()){
      currentNode = currentNode.getLeft();
    }
    return currentNode.getData();
  }

  public int findMax(){
    BinaryTreeNode currentNode = this;
    while (currentNode.hasRight()){
      currentNode = currentNode.getRight();
    }
    return currentNode.getData();
  }
  public void deleteMin(){
    BinaryTreeNode currentNode = this;
    BinaryTreeNode previousNode = null;
    while (currentNode.hasLeft()) {
      previousNode = currentNode;
      currentNode = currentNode.getLeft();
    }
    previousNode.setLeft(null);
    currentNode = null;

  
  }


  public void deleteMax(){
    BinaryTreeNode currentNode = this;
    while (currentNode.hasRight()) {
      currentNode = currentNode.getRight();
    }
    currentNode = null;
  



  }
  public void setData(int value){this.data = value;}
}
