package com.jendoliver.termites.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import com.jendoliver.termites.GameContainer;

public class RenderPure
{
	private static final int WINDOW_WIDTH = 1600;
	private static final int WINDOW_HEIGHT = 800;
	public static final int CELL_SIZE = 5;
	public static final int MS_REFRESH_RATE = 1;

	public static void main(String[] args)
	{
		Board board = new Board(WINDOW_WIDTH / CELL_SIZE, WINDOW_HEIGHT / CELL_SIZE);
		AntBasic algorithm = new AntBasic(board);

		JFrame frame = new JFrame("Lolo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.BLACK);
		GameContainer container = new GameContainer(WINDOW_WIDTH, WINDOW_HEIGHT)
		{
			private static final long serialVersionUID = 3665583574418165971L;

			@Override
			public void paintComponent(Graphics g)
			{
				Color[][] matrix = board.getMatrix();
				for(int i = 0; i < board.getHeight(); i++)
				{
					for(int j = 0; j < board.getWidth(); j++)
					{
						g.setColor(matrix[i][j]);
						g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
					}
				}
			}
		};
		frame.add(container);
		frame.setSize(container.getWindowWidth(), container.getWindowWidth());
		frame.setVisible(true);

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				algorithm.step();
				frame.repaint();
			}
		}, MS_REFRESH_RATE, MS_REFRESH_RATE);
	}
}
