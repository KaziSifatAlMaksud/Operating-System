#include<pthread.h>
#include<stdio.h>
#include <sys/types.h>
#include<sys/wait.h>
#include <unistd.h>
int value=0;
int x=0,y=0;
int q=0;
int add=0,sub =0;
void *input_value(void *param);
void *choice(void *param);
void *display(void *param);
int main(int argc,char *argv[])
{
int pid;
pthread_t tid1,tid2,tid3;
/*pthread_attr_t attr;
pid=fork();
if(pid==0){*/
//pthread_attr_init(&attr);
pthread_create(&tid1,NULL,input_value,NULL);
pthread_join(tid1,NULL);
//printf("printf: %d",y);
pthread_create(&tid2,NULL,choice,NULL);
pthread_join(tid2,NULL);


//pthread_create(&tid3,NULL,runner,NULL);
//pthread_join(tid,NULL);
//printf("CHILD VALUE=%d\n",value);
//}
/*else if(pid>0){
  wait(NULL);
printf("PARENT VALUE=%d",value);
}*/
}
void *input_value(void *param){
    printf("first value input: ");
    int a,b;
    scanf("%d",&a);
    x=a;
    printf("Secend value input: ");
    scanf("%d",&b);
    y =b;
    pthread_exit(0);
}

void *choice(void *param){
    int add,sub,ch;

    printf("press 1 for addition & press 2 for Subtraction: ");
    scanf("%d",&ch);
    q = ch;
    if(q ==1){
        pthread_t tid3;

        add= x+y;
        pthread_create(&tid3,NULL,display,&add);
        pthread_join(tid3,NULL);
    }
    else if (q == 2){
        pthread_t tid3;
        sub= y - x;
        pthread_create(&tid3,NULL,display,&sub);
        pthread_join(tid3,NULL);
    }
pthread_exit(0);
}
void *display(void *param){
    if(q == 1){
        int* addition = (int*)param;
        int add2 = *addition;
      printf("addition value is : %d",add2);
    }
    else if (q ==2){
        int* Subtraction = (int*)param;
        int sub2 = *Subtraction;
        printf("Subtraction value is : %d",sub2);
    }
    pthread_exit(0);
}
