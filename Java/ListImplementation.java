class ListImplementation{
  public static Node head;



  public static void main(String[] args) {
    ListImplementation list = new ListImplementation();
    list.addNode(new Node(8));
    list.addNode(new Node(10));
    list.addNode(new Node(1));
    list.addNode(new Node(90));
    list.addNode(new Node(17));
    list.addNode(new Node(22));
    list.addNode(new Node(5555),3);
    list.printList();
    System.out.println(list.getSize());

    list.removeNodeFromData(22);
    list.removeNodeFromData(10);
    list.printList();
    list.removeNodeFromIndex(3);
    list.printList();

    
  }

  public void addNode(Node node){
    if (headNull()){
      head = node;
      return;
    }
    Node currentNode = head;
    while(currentNode.getNext() != null){
      currentNode = currentNode.getNext();

    }
    
    currentNode.setNext(node);
    

  }
  
  public void removeNodeFromIndex(int index){

    int counter = 0;
    if (headNull()){
      System.out.println("Empty List, could not add");
      return;
    }
    Node currentNode = head;
    while (currentNode.getNext() != null && counter < index - 2){
      currentNode = currentNode.getNext();
      counter++;
    }
    if (counter != index - 2){
      System.out.println("List shorter than requested position");
      return;
    }
    if (currentNode.getNext() != null && currentNode.getNext().getNext() != null){

      currentNode.setNext(currentNode.getNext().getNext());
    }
    else{System.out.println("List shorter than requested position");}
    


  }
  public void removeNodeFromData(int data){
    if (headNull()){
      System.out.println("Empty List, could not remove");
      return;
    }
    Node currentNode = head;
    if (head.getData() == data){head = head.getNext();}
    while (currentNode.getNext()!=null && currentNode.getNext().getData()!=data  ){
      currentNode = currentNode.getNext();
    }
    if (currentNode.getNext() == null) {
      System.out.println("End of list reached and no Node found");
      return;
    }
    currentNode.setNext(currentNode.getNext().getNext());
    removeNodeFromData(data);
  }


  public boolean headNull() {
    if (head == null) {
      return true;
    }
    return false;


  }

  public void addNode(Node node, int index){
    int counter = 0;
    if (headNull()){
      System.out.println("Empty List, could not add");
      return;
    }
    Node currentNode = head;
    while (currentNode.getNext() != null && counter < index - 1){
      currentNode = currentNode.getNext();
      counter++;
    }
    if (counter != index - 1){
      System.out.println("List shorter than requested position");
      return;
    }
    node.setNext(currentNode.getNext());
    currentNode.setNext(node);
    System.out.println("Node added succesfully at index:" + index);

  }
  public int getSize(){
    int counter = 1;
    if (headNull()){
      return counter;
    }
    
    Node currentNode = head;
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
      counter++;
    
    }
    return counter;

  }

  public void printList(){
    if (headNull()){System.out.println("-----------");}
    Node currentNode = head;
    System.out.print(currentNode.getData() + "->");
    while (currentNode.getNext()!=null) {
      currentNode = currentNode.getNext();
      System.out.print(currentNode.getData() + "->");
    }
    System.out.print("NULL");
    System.out.println();

  }



}
