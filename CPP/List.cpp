#include <iostream>
class Node{
  public:

  Node(int data, Node* nextNodePointer){
  next = nextNodePointer;
  value = data;
  }

  bool hasNext(){
    if (next == nullptr){
      return false;
    }
    return true;
  }

  Node* getNext(){
    return next;
  }

  void setNext(int data){
    Node* temp = new Node(data, nullptr);
    next = temp;
  }
  int getData(){
    return value;
  }

  private:
  Node *next;
  int value;

};

class List{
  private:
  Node *head;
  public:
  List() : head(nullptr) {};
  bool isEmpty();
  void addNode(int data);
  void removeNode(int data);
  int getLength();
  void printList();

};



bool List::isEmpty(){
  if (head == nullptr){
    std::cerr << "LIST IS EMPTY\n";
    return true;
  }
  return false;
}

void List::addNode(int data){
  if (isEmpty()){
    Node *temp = new Node(data, nullptr);
    head = temp; 
    return;
  }
  Node *counterNode = head;  
  while (counterNode->hasNext()){
    counterNode = counterNode->getNext();
  }
  counterNode->setNext(data);
}

void List::removeNode(int data){
  if (isEmpty()){return;}

  if (head->getData() == data){
    Node* temp = head;
    head = head->getNext();
    delete temp;
    return;
  }

  Node *counterNode = head;
  while (counterNode->hasNext()){
    if (counterNode->getNext()->getData() == data){
      counterNode->setNext(counterNode->getNext()->getNext()->getData());
      return;
    }
    counterNode = counterNode->getNext();
  }
}

void List::printList(){
  if (isEmpty()){return;}

  Node *counterNode = head; 
  while (counterNode->hasNext()){
    std::cout << counterNode->getData() << " -> ";
    counterNode = counterNode->getNext();
  }
  std::cout << counterNode->getData() << " -> ";
  std::cout << "END\n";

}

int main (int argc, char *argv[]) {
  List *list = new List();
  list->addNode(5);
  list->addNode(17);
  list->addNode(3);
  list->addNode(5);
  list->addNode(5);
  list->printList();
  list->removeNode(5);
  list->printList();

  return 0;
}
