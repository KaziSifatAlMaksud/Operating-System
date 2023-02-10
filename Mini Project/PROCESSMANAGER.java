package processmanager;
import java.util.*;
class Process1{
    int at, bt, pri, pno;
    Process1(int pno, int at, int bt, int pri)
    {
        this.pno = pno;
        this.pri = pri;
        this.at = at;
        this.bt = bt;
    }
}
class Process
{
    int pid; 
    int bt; 
    int art;
     
    public Process(int pid, int bt, int art)
    {
        this.pid = pid;
        this.bt = bt;
        this.art = art;
    }
}
public class PROCESSMANAGER {
    
    public static int size=8;
    public static void main(String[] args) {
     Scanner inp=new Scanner(System.in);
     while(true){
     System.out.println();
     System.out.println("===================================");
     System.out.println("FCFS PRESS 1");
     System.out.println("ROUND ROBIN PRESS 2");
     System.out.println("SJF(non-preemptive) PRESS 3");
     System.out.println("SRTF OR SJF PREMTIVE PRESS 4");
     System.out.println("PRIORIRY (NON PREMTIVE) PRESS 5");
     System.out.println("PRIORIRY (PREMTIVE) PRESS 6");
     System.out.println("===================================");
     System.out.println("ENTER YOUR CHOICE");
     int choice=inp.nextInt();
     if(choice==1){
     int p=1;
     System.out.println("ENTER THE NUMBER OF PROCESS");
        int n =inp.nextInt();
        int processes[] =new int[n];
        //fcfs
        String process[] = new String[n];
        int burst_time[] =new int[n];
        for (int i = 0; i < n; i++) {
            process[i] = "P" + p;
            p++;
        }
        System.out.println(Arrays.toString(process));
        System.out.println ("ENTER PROCESS " + n + " BURST TIMES:");
for(int i=0;i<n;i++)
{
burst_time[i] = inp.nextInt();
processes[i]=i+1;
}
 System.out.println(Arrays.toString(burst_time));
        findavgTime(processes, n, burst_time);
}
     else if(choice==2){
        //round robin
        int p=1;
        System.out.println("ENTER THE NUMBER OF PROCESS");
        int n =inp.nextInt();
        String process[] = new String[n];
        int processes[] =new int[n];
        int burst_time[] =new int[n];
        for (int i = 0; i < n; i++) {
            process[i] = "P" + p;
            p++;
        }
        System.out.println(Arrays.toString(process));
        System.out.println ("ENTER PROCESS " + n + " BURST TIMES:");
for(int i=0;i<n;i++)
{
burst_time[i] = inp.nextInt();
processes[i]=i+1;
}
System.out.println(Arrays.toString(burst_time));
int quantum = 2;
        findavgTime(processes, n, burst_time, quantum);
 }
     else if(choice==3){
        
     System.out.println ("ENTER NUMBER OF PROCESS:");
int p=1;
int n = inp.nextInt();
int pid[] = new int[n];
int at[] = new int[n]; 
int bt[] = new int[n]; 
int ct[] = new int[n]; 
int ta[] = new int[n]; 
int wt[] = new int[n];  
int f[] = new int[n];  
int st=0, tot=0;
float avgwt=0, avgta=0;
String process[] = new String[n];
        int burst_time[] =new int[n];
        for (int i = 0; i < n; i++) {
            process[i] = "P" + p;
            p++;
        }
        System.out.println(Arrays.toString(process));
System.out.println ("ENTER PROCESS " + n + " ARIVAL TIMES:");
for(int i=0;i<n;i++)
{
at[i] = inp.nextInt();
pid[i] = i+1;
f[i] = 0;
}
System.out.println(Arrays.toString(at));
System.out.println ("ENTER PROCESS " + n + " BURST TIMES:");
for(int i=0;i<n;i++)
{
bt[i] = inp.nextInt();
}
System.out.println(Arrays.toString(bt));
boolean a = true;
while(true)
{
int c=n, min=999;
if (tot == n)
break;
for (int i=0; i<n; i++)
{

if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
{
min=bt[i];
c=i;
}
}

if (c==n)
st++;
else
{
ct[c]=st+bt[c];
st+=bt[c];
ta[c]=ct[c]-at[c];
wt[c]=ta[c]-bt[c];
f[c]=1;
tot++;
}
}
System.out.println("\npid  arrival  brust   complete  turn  waiting");
for(int i=0;i<n;i++)
{
avgwt+= wt[i];
avgta+= ta[i];
System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
}
System.out.println ("\naverage tat is "+ (float)(avgta/n));
System.out.println ("average wt is "+ (float)(avgwt/n));
 }
 else if(choice==4){
    //SRTF OR SJF PREMTIVE VERSION
         System.out.println("ENTER THE NUMBER OF PROCESSES");
         int n=inp.nextInt();
         int p=1;
         String process[] = new String[n];
         int burst_time[] =new int[n];
         for (int i = 0; i < n; i++) {
            process[i] = "P" + p;
            p++;
        }
         System.out.println(Arrays.toString(process));
         Process pro[]=new Process[n];
         System.out.println("ENTER THE BRUST TIMES AND ARIVAL TIMES OF "+n+" PROCESSES");
         for(int i=0;i<n;i++){
         int br=inp.nextInt();
         int ar=inp.nextInt();
         pro[i]=new Process(i+1, br, ar);
         System.out.println("["+(i+1)+" "+br+" "+ar+"]");
         }
         
      findavgTimeSR(pro, n);
     }
     else if(choice==5){
     
     int p = 1,numberOfProcess;
     System.out.println("ENTER THE PROCESS NUMBERS");
     numberOfProcess=inp.nextInt();
     String process[] = new String[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            
            process[i] = "P" + p;
            p++;
        }
        System.out.println(Arrays.toString(process));

        System.out.print("ENTER BURST TIME FOR " +numberOfProcess + "PROCESS: ");

        int burstTime[] = new int[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            burstTime[i] = inp.nextInt();
        }

        System.out.println(Arrays.toString(burstTime));

        System.out.print("ENTER PRIORITY FOR " +numberOfProcess + " PROCESS: ");

        int priority[] = new int[5];
        for (int i = 0; i < 5; i++) {
            priority[i] = inp.nextInt();
        }

        System.out.println(Arrays.toString(priority));

int temp;
String temp2;
for (int i = 0; i < numberOfProcess - 1; i++) {
      for (int j = 0; j < numberOfProcess - 1; j++) {
            if (priority[j] > priority[j + 1]) {
                   temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    temp2 = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp2;

                }
            }
        }

        int TAT[] = new int[numberOfProcess + 1];
        int waitingTime[] = new int[numberOfProcess + 1];

        for (int i = 0; i < numberOfProcess; i++) {
            TAT[i] = burstTime[i] + waitingTime[i];
            waitingTime[i + 1] = TAT[i];
        }

        int totalWT = 0;
        int totalTAT = 0;
        double avgWT;
        double avgTAT;

        System.out.println("Process     BT      WT        TAT");
        for (int i = 0; i < numberOfProcess; i++) {

            System.out.println(process[i] + "          " + burstTime[i] + "       " + waitingTime[i] + "         " + (TAT[i]));
            totalTAT += (waitingTime[i] + burstTime[i]);
            totalWT += waitingTime[i];

        }

        avgWT = totalWT / (double) numberOfProcess;
        avgTAT = totalTAT / (double) numberOfProcess;

        System.out.println("\n Average Wating Time: " + avgWT);
        System.out.println(" Average Turn Around Time: " + avgTAT);
        
     }
     else if(choice==6){
 
    System.out.println("ENTER THE NUMBER OF PROCESS");
    int n=inp.nextInt();
    int arrivalTime[]=new int[n];
    int[] burstTime=new int[n];
    int priority[]=new int[n+1];
    int x[]=new int[n];
    int waitingTime[]=new int[n];
    int turnaroundTime[]=new int[n];
    int completionTime[]=new int[n];
    int p=1;
    String process[] = new String[n];
    for (int i = 0; i < n; i++) 
    {
            process[i] = "P" + p;
            p++;
    }
    System.out.println(Arrays.toString(process));
    System.out.print("ENTER ARIVAL TIME FOR " +n + "PROCESS: ");
    for(int i=0;i<n;i++){
    arrivalTime[i]=inp.nextInt();
    }
    System.out.println(Arrays.toString(arrivalTime));
    System.out.print("ENTER BURST TIME FOR " +n + "PROCESS: ");
    for(int i=0;i<n;i++){
    burstTime[i]=inp.nextInt();
    }
    System.out.println(Arrays.toString(burstTime));
    System.out.print("ENTER PRIORITY TIME FOR " +n + "PROCESS: ");
    for(int i=0;i<n;i++){
    priority[i]=inp.nextInt();
    }
    System.out.println(Arrays.toString(priority));
    int X[]=new int[n];
    int i, j, smallest, count = 0, time; 
    double avg = 0, tt = 0, end;

    for (i = 0; i < n; i++)
        X[i] = burstTime[i];
    System.out.println(Arrays.toString(x));
    priority[n] = 10000;

    for (time = 0; count != n; time++)
    {
        smallest = n;
        for (i = 0; i < n; i++)
        {
            if (arrivalTime[i] <= time && priority[i] < priority[smallest] && burstTime[i] > 0)
                smallest = i;
        }
        burstTime[smallest]--;
        if (burstTime[smallest] == 0)
        {
            count++;
            end = time + 1;
            completionTime[smallest] =  (int)end;
            waitingTime[smallest] = (int)end - arrivalTime[smallest] - x[smallest];
            turnaroundTime[smallest] = (int)end - arrivalTime[smallest];
        }
    }
    System.out.println( "Process"
        +"     "+
        "burst-time"
        +"     "+
        "arrival-time"
        +"     "+
        "waiting-time"+
        "      "+
        "turnaround-time"
        +"     "
        +"completion-time"
        +"     "
        +"Priority");
    for (i = 0; i < n; i++)
    {
        System.out.println("p"+(i + 1) + "\t\t" + X[i] + "\t\t" +arrivalTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + completionTime[i] +"\t\t" + priority[i]);
        avg = avg + waitingTime[i];
        tt = tt + turnaroundTime[i];
    }
    System.out.println( "Average waiting time time = " + avg / n);
    System.out.println("Average turnaround time time = "+tt); 
         
    }
    }
    }
    //FCFS WORK
    static void findWaitingTime(int processes[], int n,
            int bt[], int wt[]) {
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }
 
    static void findTurnAroundTime(int processes[], int n,
            int bt[], int wt[], int tat[]) {
        
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }
    static void findavgTime(int processes[], int n, int bt[]) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);
        System.out.printf("Processes Burst time Waiting"
                       +" time Turn around time\n");
 
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("     %d ", bt[i]);
            System.out.printf("     %d", wt[i]);
            System.out.printf("     %d\n", tat[i]);
        }
        float s = (float)total_wt /(float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }
//round robin work
static void findavgTime(int processes[], int n, int bt[],
                                         int quantum)
    {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        findWaitingTime(processes, n, bt, wt, quantum);
        findTurnAroundTimeRR(processes, n, bt, wt, tat);
        System.out.println("Processes " + " Burst time " +
                      " Waiting time " + " Turn around time");
     
        for (int i=0; i<n; i++)
        {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " +
                              wt[i] +"\t\t " + tat[i]);
        }
      
        System.out.println("Average waiting time = " +
                          (float)total_wt / (float)n);
        System.out.println("Average turn around time = " +
                           (float)total_tat / (float)n);
    }
static void findTurnAroundTimeRR(int processes[], int n,
                            int bt[], int wt[], int tat[])
    {
       
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
static void findWaitingTime(int processes[], int n,
                 int bt[], int wt[], int quantum)
    {
        int rem_bt[] = new int[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  bt[i];
      
        int t = 0; 
        while(true)
        {
            boolean done = true;
      
            for (int i = 0 ; i < n; i++)
            {
      
                if (rem_bt[i] > 0)
                {
                    done = false;
      
                    if (rem_bt[i] > quantum)
                    {
                       
                        t += quantum;
      
                        rem_bt[i] -= quantum;
                    }
      
                    else
                    {
                        
                        t = t + rem_bt[i];
                        
                        wt[i] = t - bt[i];
      
                        rem_bt[i] = 0;
                    }
                }
            }
      
            if (done == true)
              break;
        }
    }
//SRTF
  
    static void findWaitingTimeSR(Process proc[], int n,
                                     int wt[])
    {
        int rt[] = new int[n];
      
        for (int i = 0; i < n; i++)
            rt[i] = proc[i].bt;
      
        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
        int shortest = 0, finish_time;
        boolean check = false;
      
        while (complete != n) {
      
            
            for (int j = 0; j < n; j++)
            {
                if ((proc[j].art <= t) &&
                  (rt[j] < minm) && rt[j] > 0) {
                    minm = rt[j];
                    shortest = j;
                    check = true;
                }
            }
      
            if (check == false) {
                t++;
                continue;
            }
      
            rt[shortest]--;
      
            minm = rt[shortest];
            if (minm == 0)
                minm = Integer.MAX_VALUE;
      
            if (rt[shortest] == 0) 
            {
      
                complete++;
                check = false;
      
                finish_time = t + 1;
      
                wt[shortest] = finish_time -
                             proc[shortest].bt -
                             proc[shortest].art;
      
                if (wt[shortest] < 0)
                    wt[shortest] = 0;
            }
            
            t++;
        }
    }
      
    static void findTurnAroundTimeSR(Process proc[], int n,
                            int wt[], int tat[])
    {
        
        for (int i = 0; i < n; i++)
            tat[i] = proc[i].bt + wt[i];
    }
      
    static void findavgTimeSR(Process proc[], int n)
    {
        int wt[] = new int[n], tat[] = new int[n];
        int  total_wt = 0, total_tat = 0;
      
        findWaitingTimeSR(proc, n, wt);
      
        findTurnAroundTimeSR(proc, n, wt, tat);
      
        System.out.println("Processes " +
                           " Burst time " +
                           " Waiting time " +
                           " Turn around time");
      
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.println(" " + proc[i].pid + "\t\t"
                             + proc[i].bt + "\t\t " + wt[i]
                             + "\t\t" + tat[i]);
        }
      
        System.out.println("Average waiting time = " +
                          (float)total_wt / (float)n);
        System.out.println("Average turn around time = " +
                           (float)total_tat / (float)n);
    }
      
}
