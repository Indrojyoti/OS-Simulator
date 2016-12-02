package simulator;

import java.io.*;
public class random
{
	public int[] b;
	public int[] a;
	public int[] p;
	public int t, m, n;

	random()
	{
		n = 10;
		b = new int[10];
		a = new int[10];
		p = new int[10];
		m = 10;
	}

	public static  void main(String[] args)
	{

	}

	public void generate()
	{
		//some x = new some();

		RandomInput e = new RandomInput(this.n, this.m);
		this.b = e.randomGeneration();

		RandomInput ee = new RandomInput(this.n, this.m);
		this.a = ee.randomGeneration();

		RandomInput eee = new RandomInput(this.n, this.m);
		this.p = eee.randomGeneration();

		this.t = 4;

	}
}
