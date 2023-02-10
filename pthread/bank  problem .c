#include<pthread.h>
#include<stdio.h>
#include <sys/types.h>
#include<sys/wait.h>
#include <unistd.h>
    int bal = 0;
    void *withdraw(void *param);
    void *deposit(void *param);
    void *display(void *param);
            //main fuction ; 
int main(int argc,char *argv[]) {
    int pid;
    pthread_t tid1,tid2,tid3;
    int choi=0,dip,wit;
    pid=fork();
        if(pid==0){
            while(choi != 3){
                
            printf("===Manu===\n");
            printf("choice 1 for diposit: \n");
            printf("choice 2 for withdrow: \n");
            printf("choice 3 for exit\n");
            
            scanf("%d",&choi);
            if(choi ==1){
                printf("diposit value: ");
                scanf("%d",&dip);
                pthread_create(&tid2,NULL,deposit,&dip);
                pthread_join(tid1,NULL);
                 pthread_create(&tid3,NULL,display,NULL);
                pthread_join(tid3,NULL);
            }
            if(choi ==2){
                printf("withdraw value: ");
                scanf("%d",&wit);
                pthread_create(&tid1,NULL,withdraw,&wit);
                pthread_join(tid2,NULL); 
                 pthread_create(&tid3,NULL,display,NULL);
                 pthread_join(tid3,NULL);
            }
            if(choi == 3){
                choi = 3;
            }
                
            }
        }else if(pid>0){
            wait(NULL);
        printf("\n\nOperations are Done ! congrats");
}
}
            //withdraw function
void *withdraw(void *param){
    int* value = (int*)param;
    bal = bal - *value;
    pthread_exit(0);
}

                //deposit function
void *deposit(void *param){
    
    int* value = (int*)param;
    bal = bal + *value;
pthread_exit(0);
}
void *display(void *param){
     //int* value = (int*)param;
     
     printf("courrent value: %d\n",bal);
    pthread_exit(0);
}
