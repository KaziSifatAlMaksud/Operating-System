//set B
#include<stdio.h>
#include<pthread.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/syscall.h>
#include <unistd.h>
#include <threads.h>
#include <sys/wait.h>
int n1,n2,sub,add;
int count=0,count1=0;
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
void *inputvalue()
{
    pthread_mutex_lock(&mutex);
    printf("\nENTER TWO NUMBERS ");
    scanf("%d",&n1);
    scanf("%d",&n2);
    pthread_mutex_unlock(&mutex);
    pthread_exit(NULL);
}
void *menue()
{
    pthread_mutex_lock(&mutex);
    printf("\n1 ADDITION");
    printf("\n2 SUBSTRACTION");
    int choice;
    printf("\n");
    scanf("%d",&choice);
    if(choice==1)
    {
        add=n1+n2;
        count++;
    }
    else if(choice==2)
    {
        count1++;
        sub=abs(n1-n2);
    }
    pthread_mutex_unlock(&mutex);
    pthread_exit(NULL);
}
void *display(){
pthread_mutex_lock(&mutex);
    if(count>0){
    printf("\nADDITION %d",add);
    count=0;
    }
    else if(count1>0){
    printf("\nSUBTRACTION %d",sub);
    count1=0;
    }
    pthread_mutex_unlock(&mutex);
    pthread_exit(NULL);
}
int main()
{
    pthread_t thread1,thread2,thread3;
    pid_t pid = fork();
    if(pid<0)
        printf("\nERROR");
    else if(pid==0)
    {
        printf("\nCHILD PROCESS EXCUTING");
        pthread_create(&thread1, NULL,inputvalue, NULL);
        pthread_create(&thread2, NULL,menue, NULL);
        pthread_create(&thread3, NULL,display,NULL);
        pthread_join(thread1, NULL);
        pthread_join(thread2, NULL);
        pthread_join(thread3, NULL);

    }
    else
    {
        wait(NULL);
        printf("\nCONGRATES OPERATION DONE");
        printf("\nPROCESS TERMINATING");
        printf("\n");
    }
    return 0;
}
///null ,pthread join,mutexlock
