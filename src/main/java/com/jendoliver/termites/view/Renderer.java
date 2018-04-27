package com.jendoliver.termites.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.jendoliver.termites.model.Board;

public abstract class Renderer extends JPanel
{
	private static final long serialVersionUID = -3808969459987824467L;

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 850;

	protected Board board;

	public Renderer(Board board)
	{
		this.board = board;
		setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		render(g);
	}

	public abstract void render(Graphics g);
}
