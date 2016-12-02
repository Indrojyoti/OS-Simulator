package simulator;

import java.util.Arrays;


public class clook {
	int[] Output;
	int Output1;
	public clook(int head,int[] in){
		Output = new int[in.length+1];
		int[] temp=new int[in.length+1];
// stuff into Output array;
		Output1=0;
		int index=0;
		for(int i=0;i<in.length;i++)
		{
			temp[i]=in[i];
		}
		temp[in.length]=head;
		Arrays.sort(temp);
		for(int i=0;i<temp.length;i++)
		{
			if(temp[i]==head)
			{
				index=i;
				break;
			}
		}
		if(head<=100)
	     {
			int j=0;
	     for(int i=index;i>=0;i--)
	     {
	     Output[j]=temp[i];
	     j++;
	     }


		for(int i=temp.length-1;i>=index+1;i--){
			Output[j]=temp[i];
			j++;
			}
	     }
	     else{
	    	 int j=0;
	    	   for(int i=index;i<temp.length;i++)
	    	     {
	    	     Output[j]=temp[i];
	    	     j++;
	    	     }



	    		for(int i=0;i<index;i++){
	    			Output[j]=temp[i];
	    			j++;

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
