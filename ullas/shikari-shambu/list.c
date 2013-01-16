#include <stdio.h>
#include <malloc.h>

struct node {int data; struct node* next; };
typedef struct node Node;

Node* initialize_list(int ary[], int len);
Node* remove_dup_from_list(Node* head);
void rem_dup(Node* n);
void print_list(Node* head);
Node* nth_to_last(Node* head, int n);
int delete_node(Node* n);
Node* rev(Node* head);
Node* append(Node* head, int data);
int delete_list(Node* head);
Node* add_nums_as_list(Node* a, Node* b);

int main(void)
{
  int a[] = {1, 1, 2, 1, 3, 1, 1, 0, 7, 8, 7};
  Node* h = initialize_list(a, 11);
  printf("Before:\n");
  print_list(h);
  remove_dup_from_list(h);
  printf("After:\n");
  print_list(h);

  printf("2nd from last: %d\n", (nth_to_last(h, 2))->data);
  printf("3rd from last: %d\n", (nth_to_last(h, 3))->data);
  printf("1st from last: %d\n", (nth_to_last(h, 1))->data);

  if (delete_node(h->next) == 0)
    print_list(h);
  printf("Reverse: \n");
  h = rev(h);
  print_list(h);
  printf("\nSum: ");
  print_list(add_nums_as_list(h, h->next));
  return 0;
}

Node* add_nums_as_list(Node* a, Node* b)
{
  Node *x, *y, *sum;
  int carry, s, xdata, ydata;
  sum = NULL;
  x = a, y = b;
  carry = s = xdata = ydata = 0;
  while(x || y) {
    if (x) xdata = x->data;
    else xdata = 0;

    if (y) ydata = y->data;
    else ydata = 0;

    s = xdata + ydata + carry;
    if (s > 9) {
      carry = s / 10;
      s = s % 10;
    }
    sum = append(sum, s);
    if(x) x = x->next;
    if(y) y = y->next;
  }
  if (carry) sum = append(sum, carry);
  return rev(sum);
}

Node* append(Node* head, int data)
{
  Node* n = malloc(sizeof(Node));
  
  n->data = data;
  n->next = head;
  return n;
}

int delete_list(Node* head)
{
  if (!head) return -1;
  Node *n, *next;

  n = head;
  while(n) {
    next = n->next;
    free(n);
    n = next;
  }
}

Node* rev(Node* head)
{
  Node* cpy = NULL;
  Node* n;

  n = head;
  while(n) {
    cpy = append(cpy, n->data);
    n = n->next;
  }
  delete_list(head);
  return cpy;
}

int delete_node(Node* n)
{
  //Can't delete the last node
  if (n == NULL || n->next == NULL) return -1;
  
  // Copy stuff from the next node and delete that instead
  Node* next = n->next;
  n->data = next->data;
  n->next = next->next;
  free(next);
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

Node* nth_to_last(Node* head, int n)
{
  Node* node = head;
  int l = 0;

  while(node) {
    ++l;
    node = node->next;
  }
  
  int nth = l - n - 1;
  node = head;
  while(nth && node) {
    --nth;
    node = node->next;
  }
  return node;
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
    printf("%d ", n->data);
    n = n->next;
  }
  printf("\n");
}
