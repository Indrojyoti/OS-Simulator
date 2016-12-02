package clubemall;

import java.util.Scanner;
public class sjfnonpreempt {

		// TODO Auto-generated method stub
		public int value;
		public int[] arrivalTime;
		public int[] burstTime;
		public int[] waitingTime;
		public double averageWaitingTime;
		public int s = 0;
		
		sjfnonpreempt(int n, int[] a, int[] b)
		{
			this.burstTime = new int[n];
			this.waitingTime = new int[n];		
			this.value = n;
			for(int i=0;i< this.value;i++)
			{
				this.burstTime[i] = b[i];
				//System.out.println("burst : "+this.burstTime[i]);
			}
			this.sort();
		}
		
		public void sort()
		{
			for (int c = 0; c < ( value - 1 ); c++)
			{
			      for (int d = 0; d < value - c - 1; d++)
			      {
			        if (burstTime[d] > burstTime[d+1]) /* For descending order use < */
			        {
			          int swap       = burstTime[d];
			          burstTime[d]   = burstTime[d+1];
			          burstTime[d+1] = swap;
			        }
			      }
			}
		}
		
		public void averageWaitingTimeCalc()
		{
			//implement FCFS
			this.waitingTime[0]= 0;
			for(int i=1 ; i<this.value ; i++)
			{
				s = s + this.burstTime[i-1];
				this.waitingTime[i] = s;
				//System.out.println("waiting : "+this.waitingTime[i]);
			}
		}
		
		public double printWaitingTime()
		{
			s = 0;
			//Print Waiting Time
			for(int i=0;i<this.value;i++)
			{
				s = s + this.waitingTime[i];
			}
			averageWaitingTime = (s*1.0) / this.value ;
		
			
			return averageWaitingTime;
		}

	}

