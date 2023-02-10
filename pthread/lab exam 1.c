#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
int bal =200;
void* diposit(void* p){
    int a;
    scanf("%d",&a);
    bal = bal+a;
    pthread_exit(&bal);
}

int main(){

    pthread_t t1;
    int i = bal;
    pthread_create(&t1,NULL,diposit, &i);
    int *ptr;
    pthread_join(t1, (void**)&ptr);
    printf("%i\n",*ptr);

}
