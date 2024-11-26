#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define HASH_SLOT 1000

typedef void* (*Constructor)(void* data);
typedef void (*Destructor)(void* data);
typedef void (*Iterator)(void* data, void* ctx);

typedef struct Item {
   int key;
   void* value;
} Item;

Item* Item_create(int key, void* value) {
   Item* item = malloc(sizeof(Item));
   item->key = key;
   item->value = value;
   return item;
}

void Item_free(Item* item) {
   free(item);
}

typedef struct Map {
   Item* table[HASH_SLOT];
   Constructor constructor;
   Destructor destructor;
} Map;

Map* Map_create(Constructor constructor, Destructor destructor) {
   Map* map = calloc(1, sizeof(Map));
   map->constructor = constructor;
   map->destructor = destructor;
   return map;
}

unsigned hash(int key) {
   unsigned code = key ^ 123456789;
   code *= (code << 3) - code;
   return code % HASH_SLOT;
}

void Map_free(Map* map) {
   for (size_t i = 0; i < HASH_SLOT; i++) {
      if (map->table[i] != NULL) {
         Item_free(map->table[i]);
      }
   }
   free(map);
}

int Map_set(Map* map, int key, void* value) {
   unsigned slot = hash(key);
   for (size_t i = 0; i < HASH_SLOT; i++) {
      unsigned cursor = (slot + i) % HASH_SLOT;
      Item* tmp = map->table[cursor];
      if (tmp == NULL) {
         map->table[cursor] = Item_create(key, map->constructor(value));
         return 0;
      }
      if (tmp->key == key) {
         map->destructor(tmp->value);
         tmp->value = map->constructor(value);
         return 0;
      }
   }
}

void* Map_get(Map* map, int key) {
   unsigned slot = hash(key);
   if (map->table[slot] == NULL) {
      return NULL;
   }
   for (size_t i = 0; i < HASH_SLOT; i++) {
      unsigned cursor = (slot + i) % HASH_SLOT;
      if (map->table[cursor]->key == key) {
         return map->table[cursor]->value;
      }
   }
   return NULL;
}