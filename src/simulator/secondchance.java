package simulator;

public class secondchance {
int h;
int full=0;
int[] a;
int[] ref;
int[] frame;
int repptr=0;
int count=0;
int b;
public void display()
{		int i;
		System.out.println("\nThe elements in the frame are\n");
		for(i=0;i<full;i++)
			System.out.println(frame[i]);
}
public int Pagerep(int ele)
{
int temp;
while(ref[repptr]!=0)
{
	 ref[repptr++]=0;
	 if(repptr==h)
   repptr=0;
}
temp=frame[repptr];
frame[repptr]=ele;
ref[repptr]=1;
return temp;
}
public  void Pagefault(int ele)
{
	if(full!=h)
{
		ref[full]=1;
     frame[full++]=ele;
}
//else
//System.out.println(Pagerep(ele));
}
public int Search(int ele)
{
	int i,flag;
  flag=0;
  if(full!=0)
  {
  for(i=0;i<full;i++)
  if(ele==frame[i])
  {
  	flag=1;
      ref[i]=1;
      break;
   }
  }
return flag;
}
public secondchance (int fr,int[] in)
{
	int n,i;
	h=fr;
	ref=new int[fr];
	frame=new int[fr];
	//Scanner in=new Scanner(System.in);
	///System.out.println("Enter no .of pages");
	//n=in.nextInt();
	///System.out.println("Enter page nos");
	b=in.length;
	a=new int[in.length];
  for(i=0;i<in.length;i++)
  	{
  	a[i]=in[i];
  	//System.out.println(a[i]);

  	}
  for(i=0;i<a.length;i++)
  {
                  if(Search(a[i])!=1)
                  {
                  	Pagefault(a[i]);
                      display();
                      count++;
                  }
  }
  //               System.out.print(count);
}
public int method(){
	return count;
}

public int method1(){
	return b-count;
}
}
