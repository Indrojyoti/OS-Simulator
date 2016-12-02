package simulator;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class priority
{
	//Declaration of varibales

	private double averageWaitingTime;
	private int[] burstTime;
	private int[] waitingTime;
	private int[] Priority;
	private int num;
	private int[] pid1;
	private int[] test;

	public priority(int n,int prior[],int burst[])
	{
		//constructor
		//initialization
		test = new int[n];
		pid1 = new int[n];
		num = n;
		burstTime = new int[n];
		waitingTime = new int[n];
		Priority = new int[n];
		for(int i=0;i<num;i++)
			{
			waitingTime[i]=0;
			Priority[i]=prior[i];
			burstTime[i]=burst[i];
			}

	}


	public double printWaitingTime()
	{
		for(int i=0;i<num;i++)
		{
			averageWaitingTime=averageWaitingTime+waitingTime[i];
		}
		//Print Waiting Time
		int sum = 0;
		for ( int i =0;i<num;i++)
		{
			sum=sum+burstTime[pid1[i]];
			waitingTime[pid1[i]]=sum-burstTime[pid1[i]];
		//	System.out.println("pid = "+ pid[pid1[i]] +" "+ waitingTime[pid1[i]]);
		}
		double sum1 = 0;
		for(int i = 0;i<num;i++)
		{
			sum1 = sum1 + waitingTime[i];
		}
		averageWaitingTime = sum1/num;

		return averageWaitingTime;
	}

	public double calcAverageWaitingTime()
	{
		//implement SJF and set the value to averageWaitingTime variabl
		int min,y;
		int sum=0;
		int x=0,j;
		for( int i=0;i<num;i++)
		{
			test[i]=Priority[i];

		}
		int max=test[0];
		for (int i=0;i<num;i++)
		{
			if(test[i]>max)
			{
				max=test[i];
			}

		}
		max=max+1;
		for (int i=0;i<num;i++)
		{
			min = max;
			for(j=0;j<num;j++)
			{
				if(test[j]!=-1&&test[j]<min)
				{
					min = test[j];
					x = j;
				}
				else if(test[j]!=-1&&test[j]==min)
				{
					if(burstTime[j]<burstTime[x])
					{
						min = test[j];
						x = j;
					}
				}
			}

			pid1[i]=x;
			test[x]=-1;
		}
		return printWaitingTime();
	}
}
