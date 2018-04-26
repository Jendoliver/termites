package com.jendoliver.termites.factory;

import java.awt.Color;
import java.util.Arrays;

import com.jendoliver.termites.model.Pattern;

public class PatternFactory
{
	private PatternFactory()
	{
		throw new UnsupportedOperationException("PatternFactory shouldn't be instantiated!");
	}

	public static Pattern createLangton()
	{
		return new Pattern(
				Arrays.asList(Color.BLACK, Color.WHITE),
				Arrays.asList('R', 'L'));
	}

	public static Pattern createLRRL()
	{
		return new Pattern(
				Arrays.asList(Color.BLACK, Color.YELLOW, Color.GREEN, Color.RED),
				Arrays.asList('L', 'R', 'R', 'L'));
	}

	public static Pattern createRLLRRLLR()
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

	public static Pattern createRLLLLLLLRRL()
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

	public static Pattern createSpiral()
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
