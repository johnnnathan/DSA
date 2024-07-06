#ifndef LIST_HEADER
#define LIST_HEADER


struct List;

typedef struct List{
  struct Node** head;
} List;


void addNode(List *list, Node *node);
void removeNode(List *list, Node)
#endif 
