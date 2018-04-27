package com.jendoliver.termites.view;

import java.awt.Color;
import java.awt.Graphics;

import com.jendoliver.termites.model.Board;

public class RendererPure extends Renderer
{
	private static final long serialVersionUID = 8069373575126492595L;

	public RendererPure(Board board)
	{
		super(board);
	}

	@Override
	public void render(Graphics g)
	{
		Color[][] matrix = board.getMatrix();
		for (int i = 0; i < board.getHeight(); i++)
		{
			for (int j = 0; j < board.getWidth(); j++)
			{
				g.setColor(matrix[i][j]);
				g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
			}
		}
	}
}
