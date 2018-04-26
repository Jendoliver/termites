package com.jendoliver.termites;

import java.awt.Color;

public class Board
{
	public int width;
	public int height;

	public Color[][] matrix;

	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
		matrix = new Color[height][width];
		clear();
	}

	public void clear()
	{
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				matrix[i][j] = Color.BLACK;
			}
		}
	}

	// TODO remove if OK

//	public void setLangtonPattern()
//	{
//		clear();
//		put(Color.BLACK, new Next(Color.WHITE, 'R'));
//		put(Color.WHITE, new Next(Color.BLACK, 'L'));
//	}
//	public void setLRRLPattern()
//	{
//		clear();
//		put(Color.BLACK, new Next(Color.YELLOW, 'L'));
//		put(Color.YELLOW, new Next(Color.GREEN, 'R'));
//		put(Color.GREEN, new Next(Color.RED, 'R'));
//		put(Color.RED, new Next(Color.BLACK, 'L'));
//	}
//
//	public void setRLLRRLLRPattern()
//	{
//		clear();
//		put(Color.BLACK, new Next(Color.YELLOW, 'R'));
//		put(Color.YELLOW, new Next(Color.GREEN, 'L'));
//		put(Color.GREEN, new Next(Color.RED, 'L'));
//		put(Color.RED, new Next(Color.CYAN, 'R'));
//		put(Color.CYAN, new Next(Color.MAGENTA, 'R'));
//		put(Color.MAGENTA, new Next(Color.ORANGE, 'L'));
//		put(Color.ORANGE, new Next(Color.PINK, 'L'));
//		put(Color.PINK, new Next(Color.BLACK, 'R'));
//	}
//
//	public void setRLLLLLLLRRLPattern()
//	{
//		clear();
//		put(Color.BLACK, new Next(Color.YELLOW, 'R'));
//		put(Color.YELLOW, new Next(Color.GREEN, 'L'));
//		put(Color.GREEN, new Next(Color.RED, 'L'));
//		put(Color.RED, new Next(Color.CYAN, 'L'));
//		put(Color.CYAN, new Next(Color.MAGENTA, 'L'));
//		put(Color.MAGENTA, new Next(Color.ORANGE, 'L'));
//		put(Color.ORANGE, new Next(Color.PINK, 'L'));
//		put(Color.PINK, new Next(Color.GRAY, 'L'));
//		put(Color.GRAY, new Next(Color.DARK_GRAY, 'R'));
//		put(Color.DARK_GRAY, new Next(Color.WHITE, 'R'));
//		put(Color.WHITE, new Next(Color.BLACK, 'L'));
//	}
//
//	public void setSpiralPattern()
//	{
//		clear();
//		put(Color.BLACK, new Next(Color.YELLOW, 'R'));
//		put(Color.YELLOW, new Next(Color.GREEN, 'L'));
//		put(Color.GREEN, new Next(Color.RED, 'L'));
//		put(Color.RED, new Next(Color.CYAN, 'L'));
//		put(Color.CYAN, new Next(Color.MAGENTA, 'L'));
//		put(Color.MAGENTA, new Next(Color.ORANGE, 'R'));
//		put(Color.ORANGE, new Next(Color.PINK, 'R'));
//		put(Color.PINK, new Next(Color.GRAY, 'R'));
//		put(Color.GRAY, new Next(Color.DARK_GRAY, 'L'));
//		put(Color.DARK_GRAY, new Next(Color.WHITE, 'L'));
//		put(Color.WHITE, new Next(Color.BLACK, 'L'));
//	}
}
