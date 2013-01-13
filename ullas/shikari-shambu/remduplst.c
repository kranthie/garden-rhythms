#include <stdio.h>
#include <malloc.h>

struct node {int data; struct node* next; };
typedef struct node Node;

Node* initialize_list(int ary[], int len);
Node* remove_dup_from_list(Node* head);
void rem_dup(Node* n);
void print_list(Node* head);

int main(void)
{
  int a[] = {1, 1, 2, 1, 3, 1, 1, 0, 7, 8, 7};
  Node* h = initialize_list(a, 11);
  printf("Before:\n");
  print_list(h);
  remove_dup_from_list(h);
  printf("After:\n");
  print_list(h);

  return 0;
}

Node* initialize_list(int ary[], int len)
{
  Node *n,*prev;
  n = prev = NULL;

  for (int i=0; i<len; ++i) {
    n = malloc(sizeof(Node));

    if(n) {
      n->data = ary[i];
      n->next = prev;
      prev = n;
    }
  }
  return n;
}

Node* remove_dup_from_list(Node* head)
{
  Node *n = head;

  while(n) {
    rem_dup(n);
    n = n->next;
  }
}

void rem_dup(Node* n)
{
  Node* p = n->next;
  Node* prev = n;

  while(p) {
    if (n->data == p->data) {
      prev->next = p->next;
      free(p);
      p = prev->next;
    } else {
      prev = p;
      p = p->next;
    }
  }
}

void print_list(Node* head)
{
  Node* n = head;

  while(n) {
    printf("%d\n", n->data);
    n = n->next;
  }
}
