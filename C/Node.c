#include "Node.h"
#include <stdlib.h>
#include <assert.h> // for assert



int main(int argc, char *argv[])
{
  Node *node = malloc(sizeof(node)); 
  return EXIT_SUCCESS;
}


void setValue(Node *current , int value){
  assert(current != NULL);
  current->data = value;
}


void setNext(Node *current , Node *next){
  assert(current != NULL);
  current->next = next;
}


int getValue(Node *current){
  return current->data;
}


Node* getNext(Node *current){
  return current->next;
}
