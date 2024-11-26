#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "part/map.c"

#define ia(x) ((int[]){x})

void* int_dup(void *x) {
   int* tmp = malloc(sizeof(int));
   *tmp = *(int*)x;
   return tmp;
}

int main() {
   Map *map = Map_create(int_dup, free);

   Map_set(map, 12, ia(1));
   Map_set(map, 43, ia(3));
   Map_set(map, 123, ia(4));

   Map_set(map, 12, ia(2));

   printf("%d\n", *(int*)Map_get(map, 12)); // 3

   return 0;
}