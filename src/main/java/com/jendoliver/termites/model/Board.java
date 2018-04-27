package com.jendoliver.termites.model;

import java.awt.Color;

public class Board
{
	private int width;
	private int height;

	private Color[][] matrix;

	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;
		matrix = new Color[height][width];
		fillBackground();
	}

	public void fillBackground()
	{
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				matrix[i][j] = Color.BLACK;
			}
		}
	}

	public final int getWidth()
	{
		return width;
	}

	public final int getHeight()
	{
		return height;
	}

	public final Color[][] getMatrix()
	{
		return matrix;
	}

	public void setMatrix(Color[][] matrix)
	{
		this.matrix = matrix;
	}

	public void changeMatrixToFit(int cellSize, int windowWidth, int windowHeight)
	{
		height = windowHeight / cellSize;
		width = windowWidth / cellSize;
		setMatrix(new Color[height][width]);
		fillBackground();
	}
}
