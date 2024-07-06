#ifndef NODE_HEADER
#define NODE_HEADER


typedef struct Node {
  int data;
  struct Node *next;
} Node;


void setValue(Node *current , int value);
void setNext(Node *current , Node *next);
int getValue(Node *current);
Node* getNext(Node *current);

#endif // !NODE_HEADER
