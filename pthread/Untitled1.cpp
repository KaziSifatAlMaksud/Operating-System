#include<iostream>
#define NODE 5
using namespace std;

int graph[NODE][NODE] = {
   {0, 1, 1, 1, 0},
   {1, 0, 1, 1, 1},
   {0, 1, 0, 1, 0},
   {1, 1, 1, 0, 1},
   {0, 1, 0, 1, 0},
};

int path[NODE];

void displayCycle() {
   cout<<"Cycle: ";

   for (int i = 0; i < NODE; i++)
      cout << path[i] << " ";
   cout << path[0] << endl;
}

int isValid(int v, int k) {
   if (graph [path[k-1]][v] == 0)
      return 0;

   for (int i = 0; i < k; i++)
      if (path[i] == v)
         return 0;
   return 1;
}

int cycleFound(int k) {
   if (k == NODE) {
      if (graph[path[k-1]][ path[0] ] == 1 ){
         return 1;
      }
      else{
         return 0;
      }
   }

   for (int v = 1; v < NODE; v++) {
      if (isValid(v,k)) {
         path[k] = v;
         if (cycleFound (k+1) == 1)
            return 1;
         path[k] = -1;
      }
   }
  // return 0;
}


int main() {

   for (int i = 0; i < NODE; i++){
        path[i] = -1;
   }
   path[0] = 0;
   int f = cycleFound(1);
   if ( f == 0) {
      printf("Solution does not exist");
   }
   displayCycle();


}
