package simulator;

public class cpufcfs
{
	private int[] burstTime;
	private int[] waitingTime;
	private double averageWaitingTime;
	private int n;

	public cpufcfs(int na,int[] burst)
	{
		burstTime=new int[na];
		waitingTime=new int[na];
		for(int i=0;i<na;i++)
		{
			burstTime[i]=burst[i];
		}

		this.n = na;
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		//System.out.println("Print the Waiting Time");
		double s = 0.0;
		for(int i=0;i<this.n;i++)
			s+=waitingTime[i];
		averageWaitingTime = (double)s/(double)this.n;
		return averageWaitingTime;
	}
	public double averageWaitingTimeCalc()
	{
		//implement FCFS

		waitingTime[0]=0;

		for(int i=1;i<this.n;i++){
			waitingTime[i]=burstTime[i-1]+waitingTime[i-1];
		}

		return this.printWaitingTime();
	}

}
