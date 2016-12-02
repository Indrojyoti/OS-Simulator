package simulator;

import java.util.Random;
import java.io.*;
public class RandomInput
{
	public int[] array;
	private int numOfProcess;
	private int maxRange;

	public RandomInput(int numOfProcess, int maxRange)
	{
		this.numOfProcess=numOfProcess;
		this.maxRange=maxRange;
		array = new int[this.numOfProcess];
	}

	public RandomInput()
	{
		numOfProcess=50;
		maxRange=50;
	}
	public RandomInput(int numOfProcess)
	{
		this.numOfProcess=numOfProcess;
		maxRange=50;
	}
	public int[] randomGeneration()
	{
		Random randomVariable=new Random();
		//create random generator here
		for (int idx=0; idx<numOfProcess;idx++)
		{
			int randomTempVar= randomVariable.nextInt(maxRange);
			array[idx] = randomTempVar;
			// another random generator
			//System.out.println(randomTempVar);
			// edit here
		}
		return array;
	}
	public void randomGenerationToFile()
	{
		//fill your code so that
	}

}
