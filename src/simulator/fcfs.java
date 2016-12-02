package simulator;

public class fcfs {
	int[] Output;
	int Output1;
	public fcfs(int head,int[] in){
		Output = new int[in.length+1];
		Output1=0;
// stuff into Output array;
		Output[0]=head;
		for(int i=1;i<=in.length;i++)
		{
			Output[i]= in[i-1];
		}
		int k=0;
		for(int i=1;i<Output.length;i++)
		{
			k=Output[i]-Output[i-1];
			if(k<0)
				k=-k;
			Output1=Output1+k;
		}
	}
	public int[] method(){
		return Output;
	}
	public int method3(){
		return Output1;
	}
}
