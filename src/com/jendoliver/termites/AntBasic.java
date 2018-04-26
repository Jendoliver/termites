package com.jendoliver.termites;

import com.jendoliver.termites.Pattern.Next;

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
		spawnAt(board.height / 2, board.width / 2);
		pattern = Pattern.ofLangton(); // Default is Langton's Ant Pattern
	}

	public void spawnAt(int row, int col)
	{
		this.i = row > 0 ? Math.min(row, board.height - 1) : 0;
		this.j = col > 0 ? Math.min(col, board.width - 1) : 0;
	}

	public void setPattern(Pattern pattern)
	{
		this.pattern = pattern;
	}

	public void setPatternAndRestart(Pattern pattern)
	{
		setPattern(pattern);
		board.clear();
		spawnAt(board.height / 2, board.width / 2);
	}

	@Override
	public void step()
	{
		Next next = pattern.get(board.matrix[i][j]);
		board.matrix[i][j] = next.color;
		currentAngle = next.direction == 'L' ? currentAngle - 1 : (currentAngle + 1) % 4;
		currentAngle = currentAngle < 0 ? 3 : currentAngle;

		switch(currentAngle)
		{
			case 0: i -= 1; break;
			case 1: j = (j + 1) % board.width; break;
			case 2: i = (i + 1) % board.height; break;
			case 3: j -= 1; break;
			default: break;
		}

		i = i < 0 ? board.height - 1 : i;
		j = j < 0 ? board.width - 1 : j;
	}
}
