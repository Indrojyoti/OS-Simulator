package simulator;

public class optimal {
	int Output;
	int b;
	public optimal(int fr,int[] in){
		int i,n,j,frame,hit=0,miss=0;
	//	int[] A;
		//System.out.println(1);
		b=in.length;
		int[] count;
		int min=100000,minj=0,k;
		count=new int[100];
		for(i=0;i<100;i++)
		{
			count[i]=0;
		}
		int[] page;
		page=new int[100];
		for(i=0;i<100;i++)
		{
			page[i]=-1;
		}
		for(i=0;i<in.length;i++)
		{
			count[in[i]]=count[in[i]]+1;
		}
//		for(i=0;i<in.length;i++){
//			System.out.println(in[i]);
//			}
		for(i=0;i<fr;i++)
			{page[i]=in[i];}
		miss=fr;
		for(i=0;i<in.length;i++)
		{
				int status=0;
				for(j=0;j<fr;j++)
				{
					if(page[j]==in[i])
					{
						status=1;
						count[page[j]]-=1;
					}
				}
				if(status==1)
				{
					hit+=1;
					//count[page[j]]-=1;
				}
				else
				{
					for(k=0;k<fr;k++)
					{
						if(count[page[k]]<min)
						{
							min=count[page[k]];
							minj=k;
						}
					}
					page[minj]=in[i];
					count[page[minj]]=count[page[minj]]-1;
					miss=miss+1;
					int p;
//					for(p=0;p<fr;p++)
//						{
//							System.out.print(page[p]);
//							System.out.print(" ");
//						}

				}
//				int p;
//				for(p=0;p<fr;p++)
//					{
//						System.out.print(page[p]);
//						System.out.print(" ");
//					}
			}
		Output=miss;
		//Hello
	}
	public int method(){
		return Output;
	}
	public int method1(){
		return b-Output;
	}
}
