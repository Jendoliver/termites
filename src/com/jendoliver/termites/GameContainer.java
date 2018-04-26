package com.jendoliver.termites;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameContainer extends JPanel
{
	private static final long serialVersionUID = -5455885489325161528L;

	public GameContainer() { }

	public GameContainer(int windowWidth, int windowHeight)
	{
		setWindowWidth(windowWidth);
		setWindowHeight(windowHeight);
	}

	public int getWindowWidth()
	{
		return (int)this.getSize().getWidth();
	}

	public void setWindowWidth(int windowWidth)
	{
		this.setSize(windowWidth, getWindowHeight());
	}

	public int getWindowHeight()
	{
		return (int)this.getSize().getHeight();
	}

	public void setWindowHeight(int windowHeight)
	{
		this.setSize(getWindowWidth(), windowHeight);
	}

	@Override
	public abstract void paintComponent(Graphics g);
}
