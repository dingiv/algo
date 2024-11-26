#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Node {
   void* data;
   struct Node* next;
} Node;

typedef void* (*Constructor)(void* data);
typedef void (*Destructor)(void* data);
typedef void (*Iterator)(void* data, void* ctx);

Node* Node_create(void* data) {
   Node* node = malloc(sizeof(Node));
   node->data = data;
   node->next = NULL;
   return node;
}

Node* Node_free(Node* node, Destructor data_destructor) {
   Node* next = node->next;
   if (data_destructor && node->data) data_destructor(node->data);
   free(node);
   return next;
}

typedef struct {
   Node* head;
   Node* tail;
   int size;
   Constructor constructor;
   Destructor destructor;
} List;

List* List_create(Constructor data_constructor, Destructor data_destructor);
void List_free(List* list);
void List_push(List* list, void* data);
void* List_shift(List* list);
void List_insert(List* list, int index, void* data);
void List_foreach(List* list, Iterator it, void* context);

List* List_create(Constructor data_constructor, Destructor data_destructor) {
   List *list = calloc(1, sizeof(List));
   list->head = list->tail = Node_create(NULL);
   list->constructor = data_constructor;
   list->destructor = data_destructor;
   return list;
}

void List_free(List *list) {
   Node* cursor = list->head;
   while (cursor) {
      cursor = Node_free(cursor, list->destructor);
   }
   free(list);
}

void List_push(List *list, void *data) {
   Node* node = Node_create(list->constructor(data));
   list->tail->next = node;
   list->tail = node;
   list->size++;
}

void* List_shift(List *list) {
   if (list->size == 0) return NULL;
   Node* cursor = list->head->next;
   list->head->next = cursor->next;
   list->destructor(cursor->data);
   free(cursor);
   list->size--;
   if (list->size == 0) list->tail = list->head;
}

void List_insert(List *list, int index, void *data) {
   Node* node = Node_create(list->constructor(data));
   node->next = list->head->next;
   list->head->next = node;
   if (list->size == 0) list->tail = node;
   list->size++;
}

void List_foreach(List *list, Iterator it, void *context) {
   Node* cursor = list->head->next;
   while (cursor) {
      it(cursor->data, context);
      cursor = cursor->next;
   }
}