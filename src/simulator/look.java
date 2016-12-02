package simulator;

import java.util.Arrays;

public class look {
	int[] Output;
	int Output1;
	public look(int head,int[] in){
		Output = new int[in.length+1];
// stuff into Output array;
		Output1=0;
		int temp[] =new int[in.length];
		int start=0;
		   for(int i=0;i<in.length;i++)
		   {
			   temp[i]=in[i];
		   }
		   Arrays.sort(temp);
		   if(head<100)
			   start=0;
		   else
			   start=199;
		   int j=0,k=0;
		   for(int i=0;i<temp.length;i++)
		 	{
		 		if(temp[i]<head)
		 		{
		 			j++;
		 			k=j;
		 		}
		 	}
		   int p=0;
		 	if(start==0)
		 	{
		 		if(head!=0 && head!=199){
		 		Output[p]=head;
		 		p=p+1;
		 		}
		 		for(int i=j-1;i>=0;i--)
		 		{
		 			if(temp[i]!=0 && temp[i]!=199){
		 			Output[p]=temp[i];
		 			p=p+1;
		 			}
		 		}
		 		if(start!=0 && start!=199){
		 		Output[p]=start;
		 		p=p+1;
		 		}
		 		for(int i=k;i<temp.length;i++)
		 		{
		 			if(temp[i]!=0 && temp[i]!=199){
		 			Output[p]=temp[i];
		 			p=p+1;
		 			}
		 		}
		 	}
		 	else
		 	{
		 		if(head!=0 && head!=199){
		 		Output[p]=head;
		 		p=p+1;
		 		}
		 		for(int i=k;i<temp.length;i++)
		 		{
		 			if(temp[i]!=0 && temp[i]!=199){
		 			Output[p]=temp[i];
		 			p=p+1;
		 			}
		 		}
		 		if(start!=0 && start!=199){
		 		Output[p]=start;
		 		p=p+1;
		 		}
		 		for(int i=j-1;i>=0;i--)
		 		{
		 			if(temp[i]!=0 && temp[i]!=199){
		 			Output[p]=temp[i];
		 		     p=p+1;
		 			}
		 		}
		 	}
		 	int h=0;
			for(int i=1;i<Output.length;i++)
			{
				h=Output[i]-Output[i-1];
				if(h<0)
					h=-h;
				Output1=Output1+h;
			}

			}
	public int[] method(){
		return Output;
	}
	public int method3(){
		return Output1;
	}

}
