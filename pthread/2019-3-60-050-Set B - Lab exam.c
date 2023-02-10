#include<pthread.h>
#include<stdio.h>
#include <string.h>
#include <sys/types.h>
#include<sys/wait.h>
#include <unistd.h>
    char *array[20];
    char str[20];
    void *read_set(void *param);
    void *separate_word(void *param);
    void *display(void *param);
            //main fuction ;
int main(int argc,char *argv[]) {
    int pid;
    pthread_t tid1,tid2,tid3;

    pid=fork();
        if(pid==0){
                pthread_create(&tid1,NULL,read_set,NULL);
                pthread_join(tid1,NULL);
                pthread_create(&tid2,NULL,separate_word,NULL);
                pthread_join(tid2,NULL);
                pthread_create(&tid3,NULL,display,NULL);
                pthread_join(tid3,NULL);
                //printf("I am child");
        }else if(pid>0){
            wait(NULL);
        printf("\n\nOperations are Done ! congrats");
             //printf("\n I am  parent.")
}
}
            //read_set function
void *read_set(void *param){

    printf("Enter the Sentence: ");
    scanf("%[^\n]%*c",str);
    pthread_exit(0);
}

                //separeate_word function
void *separate_word(void *param){
        int i = 0;
    char *p = strtok (str, " ");
    while (p != NULL)
    {
        array[i++] = p;
        p = strtok (NULL, " ");
    }

pthread_exit(0);
}
                //display function
void *display(void *param){
    int i;
    for (i = 0; i < 10; ++i)
        printf("%s\n", array[i]);
    pthread_exit(0);
}
