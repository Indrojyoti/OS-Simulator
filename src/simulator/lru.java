package simulator;

public class lru {
	int Output;
	int b;
	public lru(int fr,int[] in){
			int frame[] = new int [fr];
			int fs[] = new int [fr];
		//	int b[] = new int[n];
			int index=0,k,l,flag1=0,flag2=0,pf=0;
			b=in.length;
			for(int i=0;i<fr;i++){
				frame[i]=-1;
			}
			for(int j=0;j<in.length;j++){
				flag1=0;
				flag2=0;
				for(int i=0;i<fr;i++){
					if(frame[i]==in[j]){
						flag1=1;
						flag2=1;
						break;
					}
				}
				if(flag1==0){
					for(int i=0;i<fr;i++){
						if(frame[i]==-1){
							frame[i]=in[j];
							flag2=1;
							break;
						}
					}
				}
				if(flag2==0){
					for(int i=0;i<3;i++)
						fs[i]=0;
					for(k=j-1,l=1;l<=fr-1;l++,k--){
						for(int i=0;i<fr;i++){
							if(frame[i]==in[k])
								fs[i]=1;
						}
					}
					for(int i=0;i<3;i++){
						if(fs[i]==0)
							index=i;
					}
					frame[index]=in[j];
					pf++;
				}
			}
		Output=pf+fr;
	}
public int method(){
	return Output;
}
public int method1(){
	return b-Output;
}
}
