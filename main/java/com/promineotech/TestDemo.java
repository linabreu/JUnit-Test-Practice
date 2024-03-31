package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b)
	{
		if (a < 0 || b < 0)
		{
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		else
		{
			return a+b;
		}
	}
	
	//simple method to assign letter grade based on a test score
	public char assignLetterGrade(int score)
	{
		char returnScore  = 'x';
		if(score < 0)
		{
			throw new IllegalArgumentException ("Score must be positive!");
		}
		else if (score < 60)
		{
			returnScore = 'F';
		}
		else if (score < 70)
		{
			returnScore = 'D';
		}
		else if (score < 80)
		{
			returnScore = 'C';
		}
		else if (score < 90)
		{
			returnScore = 'B';
		}
		else if (score >=90)
		{
			returnScore = 'A';
		}
		return returnScore;
	}
	
	public int randomNumberSquared ()
	{
		int random = getRandomInt();
		return random * random;
		
	}
	public int getRandomInt()
	{
		Random random = new Random();
	    return random.nextInt(10) + 1;
	}

}
