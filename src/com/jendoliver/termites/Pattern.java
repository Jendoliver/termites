package com.jendoliver.termites;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.jendoliver.termites.Pattern.Next;

public class Pattern extends HashMap<Color, Next>
{
	private static final long serialVersionUID = 1869924159511482457L;

	public static class Next
	{
		public Color color;
		public char direction;

		public Next(Color color, char direction)
		{
			this.color = color;
			this.direction = direction;
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

	public static Pattern ofLangton()
	{
		return new Pattern(
				Arrays.asList(Color.BLACK, Color.WHITE),
				Arrays.asList('R', 'L'));
	}

	public static Pattern ofLRRL()
	{
		return new Pattern(
				Arrays.asList(Color.BLACK, Color.YELLOW, Color.GREEN, Color.RED),
				Arrays.asList('L', 'R', 'R', 'L'));
	}

	public static Pattern ofRLLRRLLR()
	{
		return new Pattern(
				Arrays.asList(
						Color.BLACK,
						Color.YELLOW,
						Color.GREEN,
						Color.RED,
						Color.CYAN,
						Color.MAGENTA,
						Color.ORANGE,
						Color.PINK),
				Arrays.asList('R', 'L', 'L', 'R', 'R', 'L', 'L', 'R'));
	}

	public static Pattern ofRLLLLLLLRRL()
	{
		return new Pattern(
				Arrays.asList(
						Color.BLACK,
						Color.YELLOW,
						Color.GREEN,
						Color.RED,
						Color.CYAN,
						Color.MAGENTA,
						Color.ORANGE,
						Color.PINK,
						Color.GRAY,
						Color.DARK_GRAY,
						Color.WHITE),
				Arrays.asList('R', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'R', 'R', 'L'));
	}

	public static Pattern ofSpiral()
	{
		return new Pattern(
				Arrays.asList(
						Color.BLACK,
						Color.YELLOW,
						Color.GREEN,
						Color.RED,
						Color.CYAN,
						Color.MAGENTA,
						Color.ORANGE,
						Color.PINK,
						Color.GRAY,
						Color.DARK_GRAY,
						Color.WHITE),
				Arrays.asList('R', 'L', 'L', 'L', 'L', 'R', 'R', 'R', 'L', 'L', 'L'));
	}
}
