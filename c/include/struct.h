#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#ifndef STRUCT_H
#define STRUCT_H

typedef struct Node {
   void* data;
   struct Node* next;
} Node;

typedef void* (*Constructor)(void* data);
typedef void (*Destructor)(void* data);
typedef void (*Iterator)(void* data, void* ctx);

Node* Node_create(void* data);
Node* Node_free(Node* node, Destructor data_destructor);

#define ia(x) ((int[]){x})


#endif