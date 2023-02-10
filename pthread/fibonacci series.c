#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/syscall.h>
#include<unistd.h>
#include<threads.h>

int n, count =0, sum=0;
void *threadFuction(void*);
long long arr[100000];
long long arr1[100000];
pthread_mutex_t mutex1= PTHREAD_MUTEX_INITIALIZER;
int main(void){
    int i =0, retVal=0;
    pthread_t *thread;

    thread = (pthread_t*)malloc(n*sizeof(pthread_t));
    for(i=0;i<4;i++){
        printf(" %d_th number your ID: ",i);
        scanf("%d",&n);

        retVal = pthread_create(&thread[i],NULL,threadFuction,(void*)&n);
        pthread_join(thread[i],NULL);
        }
        printf("\n Thread in and sum");
        printf("\n");
        for(int i=0;i<count;i++){
            printf("\n");
            printf("%lld %lld",arr[i],arr[i]);
            printf("\n");
        }
    }
void *threadFuction(void *arg){
pthread_mutex_lock(&mutex1);

printf("\n");
int t1=0,t2=1;
int nextTerm = t1+t2;
printf("Fibonacci Series: %d,%d ",t1,t2);
sum = t1 + t2;

for(int i = 3;i<=n;i++){
    printf("%d," ,nextTerm);
    sum= sum+nextTerm;
    t1=t2;
    t2 = nextTerm;
    nextTerm  = t1+t2;
}
arr[count] = thrd_current();
arr1[count] = sum;
count++;
sum=0;
pthread_mutex_unlock(&mutex1);
printf("\n");
}
