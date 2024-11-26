#include "struct.h"


#ifndef DICT_H
#define DICT_H

typedef struct KVNode {
   char *key;
   void *value;
   struct KVNode *next;
} KVNode;

typedef struct {
   KVNode** table;
   int slot;
} Dict;

#endif // DICT_H
