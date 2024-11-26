#include "struct.h"

#ifndef LIST_H
#define LIST_H

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

#endif