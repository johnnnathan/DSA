public class DoubleListImplementation {
  private static DoubleNode head;
  private static DoubleNode tail;

  public static void main(String[] args) {
    DoubleListImplementation list = new DoubleListImplementation();
    list.addNode(new DoubleNode(8));
    list.addNode(new DoubleNode(87));
    list.addNode(new DoubleNode(53));
    list.addNode(new DoubleNode(11));
    list.addNode(new DoubleNode(123134));
    list.addNode(new DoubleNode(99));
    list.addNode(new DoubleNode(101));
    list.printListTail();
    list.printList();



  }

  public void updateTail(){
    DoubleNode currentNode = head;
    while(currentNode.hasNext()){
      currentNode = currentNode.getNext();
    }
    tail = currentNode;

  }
  public void addNode(DoubleNode node){
    if (headNull()){
      head = node;
      tail = node;
      return;
    }
    DoubleNode currentNode = head;
    while(currentNode.hasNext()){
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(node);
    node.setPrevious(currentNode);

    updateTail();
  }
  public void addNode(DoubleNode node, int index){
    int counter = 1;
    if (headNull()){
      head = node;
      return;
    }
    DoubleNode currentNode = head;
    while (currentNode.hasNext() && counter < index - 1){
      currentNode = currentNode.getNext();
      counter++;
    }
    if (counter != index - 1){
      System.out.println("List shorter than requested position");
      return;
    }
    if (!currentNode.hasNext()){
      addNode(node);
      return;
    }

    node.setNext(currentNode.getNext());
    node.setPrevious(currentNode);
    currentNode.getNext().setPrevious(node);
    currentNode.setNext(node);

    updateTail();
  


  }



  public void removeNodeFromData(int data){


    int counter = 1;
    if (headNull()){
      System.out.println("Empty List");
      return;
    }
    DoubleNode currentNode = head;
    while (currentNode.hasNext() && currentNode.getNext().getData()!=data){
      currentNode = currentNode.getNext();

      counter++;

    }
    if ( currentNode.getNext() != null && currentNode.getNext().getNext() != null){
      currentNode.getNext().getNext().setPrevious(currentNode);
      currentNode.setNext(currentNode.getNext().getNext());
      removeNodeFromData(data);
      updateTail();
      return;

    }
    else{

      currentNode.setNext(null);
      updateTail();
      return;


    }






  }
  public int getSize(){
    DoubleNode currentNode = head;
    int counter = 1;
    if (headNull()){
      return 0;
    }
    while(currentNode.getNext()!=null){
      currentNode = currentNode.getNext();
      counter++;
    }

    return counter;
  }

  public void removeNodeFromIndex(int index){

    if (headNull()){
      System.out.println("Empty list");
      return;
    }
    int counter = 1;
    DoubleNode currentNode = head;
    while (currentNode.getNext() != null && counter < index - 1){
      currentNode = currentNode.getNext();
      counter++;
    }
    if (counter != index - 1){
      System.out.println("List shorter than requested position");
      return;
    }
    if (currentNode.getNext() != null && currentNode.getNext().getNext() != null){
      currentNode.getNext().getNext().setPrevious(currentNode);
      currentNode.setNext(currentNode.getNext().getNext());
      updateTail();
    }



  }

  public void printList(){
    System.out.print(head.getData());
    DoubleNode currentNode = head;
    while (currentNode.hasNext()){
      currentNode = currentNode.getNext();
      System.out.print("<->");
      System.out.print(currentNode.getData());
    }

    System.out.println();
  }
  public void printListTail(){
    System.out.print(tail.getData());
    DoubleNode currentNode = tail;
    while (currentNode.hasPrevious()){
      currentNode = currentNode.getPrevious();
      System.out.print("<->");
      System.out.print(currentNode.getData());
    }

    System.out.println();

  }
  public void printListElements(){
    System.out.println(head.getData());
    System.out.println(head.getNext().getData());

    DoubleNode node = head;
    while(node.hasNext()){
      node = node.getNext();
      System.out.println();
      System.out.println(node.getData());
      if (node.hasPrevious()){System.out.println(node.getPrevious().getData());}
      System.out.println(node.getNext().getData());

    }
  }





  public boolean headNull(){
    if (head == null){return true;}
    return false;
  }
}

