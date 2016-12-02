package simulator;

public class roundrobin
{
	//Declaration of varibales
	private double averageWaitingTime;
	private int[] pid;
	private int[] burstTime;
	private int[] waitingTime;
	//int[] ArrivalTime;
	private int num;
	private int[] pid1;
	private int[] test;
	private int timeQuantam;
	public roundrobin(int n,int q,int[] burst)
	{
		//constructor
		//initialization
		num = n;
		timeQuantam=q;
		pid = new int[n];
		burstTime = new int[n];
		waitingTime = new int[n];
		//	ArrivalTime = new int[n];
		for(int i=0;i<num;i++)
		{
			waitingTime[i]=0;
			burstTime[i]=burst[i];
		}
	}

	public double calcAverageWaitingTime()
	{
		//implement RoundRobin and set the value to averageWaitingTime variable
		int count = 0;
		for(int i = 0 ;i < num;i++)
		{
			if(burstTime[i]%timeQuantam !=0)
			{
				count++;
			}
			count = count+burstTime[i]/timeQuantam;
		}
		test = new int[count];
		pid1 = new int[count];
		int j =0;
		for(int i = 0;1<2;i++)
		{
			i = i%num;
			if(burstTime[i]!=-1)
			{
				if(burstTime[i]>timeQuantam)
				{
					pid1[j] =i;
					test[j]=timeQuantam;
					burstTime[i]=burstTime[i] - timeQuantam;
				}
				else if (burstTime[i]<=timeQuantam)
				{
					pid1[j] = i;
					test[j] =  burstTime[i];
					burstTime[i] = -1;
				}
				j++;
			}
			if(j == count)
				break;
		}
		int[] k=new int[num];
		for(int i = num-1;i>=0;i--)
		{
			k[i]=0;
		}
		for(int i = count-1;i>=0;i--)
		{
			if(k[pid1[i]]!=1)
			{
				for(j = i-1;j>=0;j--)
				{
					if(pid1[j]!=pid1[i])
					{
						// System.out.println(waitingTime[pid1[i]]+"j"+ test[pid1[j]]);
						waitingTime[pid1[i]]=waitingTime[pid1[i]]+test[j];
						//System.out.println(pid1[i] +"**"+pid1[j]+test[pid1[j]]+ waitingTime[pid1[i]]);
					}
				}
				k[pid1[i]]=1;
			}
		}
//		for(int i =0;i<num;i++)
///		{
//			System.out.println("waiting = "+waitingTime[i]);
//		}
		for(int i=0;i<num;i++)
		{
			averageWaitingTime=averageWaitingTime+waitingTime[i];
		}
		averageWaitingTime=(double)averageWaitingTime/num;

		return averageWaitingTime;

	}
}
