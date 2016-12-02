package simulator;

import java.util.Scanner;
import java.io.*;

public class sjf {

		public int value, s_burst, s;
		public int[] burstTime;
		public int[] prevTime;
		public int[] arrivalTime;
		public int[] waitingTime;
		public double averageWaitingTime;


		public sjf(int n, int[] a, int[] b)
		{
			burstTime = new int[n];
			waitingTime = new int[n];
			arrivalTime = new int[n];
			prevTime = new int[n];
			this.value = n;
			s_burst = 0;
			s = 0;
			for(int i=0;i<n;i++)
			{
				this.burstTime[i] = b[i];
				this.s_burst += b[i];
			}
			for(int i=0;i<n;i++)
				this.arrivalTime[i] = a[i];
			//this.print();
		}

		public void print()
		{
			for(int i = 0 ;i< value;i++)
				System.out.print(burstTime[i]+" ");
			System.out.println("");
			for(int i = 0 ;i< value;i++)
				System.out.print(arrivalTime[i]+" ");
			System.out.println("");
		}

		public void averageWaitingTimeCalc()
		{
			this.waitingTime[0] = 0;

			for(int i=0; i < this.s_burst; i++)
			{
				int min = 100000000, index_min = 0;
				for(int j=0;j<this.value;j++)
				{
					if (this.arrivalTime[j] <= i && this.burstTime[j] < min && this.burstTime[j] > 0)
					{
						min = this.burstTime[j];
						index_min = j;
					}
				}

				this.burstTime[index_min] -= 1;
				this.waitingTime[index_min] += i - prevTime[index_min] ;
				this.prevTime[index_min] = i+1;
			}
		//	this.printWaitingTime();
		}

		public void printw()
		{
			for(int i = 0 ;i< value;i++)
				System.out.println(waitingTime[i]);
		}

		public double printWaitingTime()
		{
			s = 0;
			for(int i=0;i<this.value;i++)
			{
				s = s + this.waitingTime[i];
			}
			averageWaitingTime = (s)*1.0 / value ;


			return averageWaitingTime;
		}

	}
