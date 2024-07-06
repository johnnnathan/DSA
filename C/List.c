#include "Node.h"
#include "List.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  Node* list = (Node *)malloc(sizeof(Node));

  return EXIT_SUCCESS;
}


void addNodeToList(List *list, Node *node){
  assert(list->head != NULL);
  Node *currentNode = list->head;
  while(currentNode->next != NULL){
    currentNode = currentNode->next;
  }
  setNext(currentNode, node);
}
void removeNode(List *list, Node);
void addNode(List *list, Node *node, int index);


#define addNode(list, node, ...) _Generic((node), \
                                          Node *: addNodeToList, \
                                          default: addNodeToListWithIndex \
                                         )(list, node, ##__VA_ARGS__)
