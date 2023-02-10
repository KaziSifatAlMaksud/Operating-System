//set A
#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <sys/wait.h>
#include <unistd.h>
#define THREAD_COUNT 10
sem_t mutex;
pthread_t thread1,thread2,thread3,thread4,thread5;
void *print1(){
sem_wait(&mutex);
printf("This ");
sem_post(&mutex);
pthread_exit(NULL);
}
void *print2(){
sem_wait(&mutex);
printf(" is ");
sem_post(&mutex);
pthread_exit(NULL);
}
sem_wait(&mutex);
printf(" CSE207");
sem_post(&mutex);
pthread_exit(NULL);
}
void *print4(){
sem_wait(&mutex);
printf(".");
sem_post(&mutex);
pthread_exit(NULL);
}
void *print5(){
sem_wait(&mutex);
pthread_create(&thread1, NULL,print1, NULL);
pthread_create(&thread2, NULL,print2, NULL);
pthread_create(&thread3, NULL,print3,NULL);
pthread_create(&thread4, NULL,print4,NULL);
pthread_join(thread1, NULL);
pthread_join(thread2, NULL);
pthread_join(thread3, NULL);
pthread_join(thread4, NULL);
sem_post(&mutex);
pthread_exit(NULL);
}
int main(){
sem_init(&mutex,0,5 );
pid_t pid = fork();
if(pid<0)
printf("\nERROR");
else if(pid==0){
printf("\nCHILD PROCESS EXCUTING");
printf("\n");
pthread_create(&thread5, NULL,print5,NULL);
pthread_join(thread5, NULL);
}
else{
wait(NULL);
printf("\nOPERATION DONE\n");
}
sem_destroy(&mutex);
}
