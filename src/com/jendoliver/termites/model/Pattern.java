package com.jendoliver.termites.model;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;

import com.jendoliver.termites.model.Pattern.Next;

public class Pattern extends HashMap<Color, Next>
{
	private static final long serialVersionUID = 1869924159511482457L;

	public static final class Next
	{
		private Color color;
		private char direction;

		public Next(Color color, char direction)
		{
			this.color = color;
			this.direction = direction;
		}

		public final Color getColor()
		{
			return color;
		}

		public final char getDirection()
		{
			return direction;
		}
	}

	public Pattern()
	{
		super();
	}

	public Pattern(List<Color> colors, List<Character> turns)
	{
		super();

		if(colors.size() != turns.size())
			throw new IllegalArgumentException("Both lists have to be equal in size");

		for(int i = 0; i < colors.size() - 1; i++)
			put(colors.get(i), new Next(colors.get(i + 1), turns.get(i)));
		put(colors.get(colors.size() - 1), new Next(colors.get(0), turns.get(turns.size() - 1)));
	}
}
