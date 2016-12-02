package clubemall;

public class sstf {
	int[] Output;
	int Output1;
	public sstf(int head,int[] in){
		Output = new int[in.length+1];
// stuff into Output array;
		Output[0]=head;
		Output1=0;
		for(int i=0;i<in.length;i++)
	     {
	    	 int j=0;
	    	 int min;
	    	 min=1000;
	    	 int k=0;
	    	 while(j<in.length)
	    	 {
	    		 if(in[j]!=-1)
	    		 {
	    		 int g;
	    		 g= Output[i]-in[j];
	    		 if(g<0)
	    			 g=-g;
	    		 if(min>g)
	    		 {
	    			 min=g;
	    			 k=j;
	    			 //3
	    			// 
	    		 }
	    		 }
	    		 j=j+1;
	    	 }
	    	 Output[i+1]=in[k];
				//System.out.println(Output[i+1]);
	    	 in[k]=-1;
	     }
		int p=0;
		for(int i=1;i<Output.length;i++)
		{
			p=Output[i]-Output[i-1];
			if(p<0)
				p=-p;
			Output1=Output1+p;
		}
		
	}
	public int[] method(){
		//for(int i=0;i<Output.length;i++)
			//System.out.println(Output[i]);
		return Output;
	}
	public int method3(){
		//for(int i=0;i<Output.length;i++)
			//System.out.println(Output[i]);
		return Output1;
	}
}
