package com.jendoliver.termites.model;

import com.jendoliver.termites.factory.PatternFactory;
import com.jendoliver.termites.model.Pattern.Next;

public class AntBasic implements AntAlgorithm
{
	private Board board;
	private Pattern pattern;
	private int i;
	private int j;
	private int currentAngle = 0; // 0 - Up, 1 - Right, 2 - Down, 3 - Left

	public AntBasic(Board board)
	{
		this.board = board;
		spawnAt(board.getHeight() / 2, board.getWidth() / 2);
		pattern = PatternFactory.createLangton(); // Default is Langton's Ant Pattern
	}

	public void spawnAt(int row, int col)
	{
		this.i = row > 0 ? Math.min(row, board.getHeight() - 1) : 0;
		this.j = col > 0 ? Math.min(col, board.getWidth() - 1) : 0;
	}

	public void setPattern(Pattern pattern)
	{
		this.pattern = pattern;
	}

	public void setPatternAndRestart(Pattern pattern)
	{
		setPattern(pattern);
		board.clear();
		spawnAt(board.getHeight() / 2, board.getWidth() / 2);
	}

	@Override
	public void step()
	{
		Next next = pattern.get(board.getMatrix()[i][j]);
		board.getMatrix()[i][j] = next.getColor();
		currentAngle = next.getDirection() == 'L' ? currentAngle - 1 : (currentAngle + 1) % 4;
		currentAngle = currentAngle < 0 ? 3 : currentAngle;

		switch(currentAngle)
		{
			case 0: i -= 1; break;
			case 1: j = (j + 1) % board.getWidth(); break;
			case 2: i = (i + 1) % board.getHeight(); break;
			case 3: j -= 1; break;
			default: break;
		}

		i = i < 0 ? board.getHeight() - 1 : i;
		j = j < 0 ? board.getWidth() - 1 : j;
	}
}
