package com.jendoliver.termites.factory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.jendoliver.termites.model.Pattern;

public class PatternFactory
{
	private PatternFactory()
	{
		throw new UnsupportedOperationException("PatternFactory shouldn't be instantiated!");
	}

	public static Pattern createRandom(int maxPatternSize)
	{
		Random random = new Random();
		int patternSize = random.nextInt(maxPatternSize);
		while(patternSize < 2)
			patternSize = random.nextInt(maxPatternSize);
		Set<Color> colors = new HashSet<>();
		colors.add(Color.BLACK);
		List<Character> turns = new ArrayList<>();
		turns.add(random.nextBoolean() ? 'L' : 'R');

		for(int i = 0; i < patternSize - 1; i++)
		{
			boolean wasNew = colors.add(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			while( ! wasNew)
				wasNew = colors.add(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			turns.add(random.nextBoolean() ? 'L' : 'R');
		}

		return new Pattern(new ArrayList<>(colors), turns);
	}

	// TODO change / remove when select color is implemented
	public static Pattern createFromString(String pattern) throws IllegalArgumentException
	{
		Random random = new Random();
		Set<Color> colors = new HashSet<>();
		colors.add(Color.BLACK);
		List<Character> turns = new ArrayList<>();
		char c = pattern.charAt(0);
		if(c != 'L' && c != 'R')
			throw new IllegalArgumentException("Please enter a string consisting of multiple L and R");
		turns.add(c);

		for(int i = 1; i < pattern.length(); i++)
		{
			c = pattern.charAt(i);
			if(c != 'L' && c != 'R')
				throw new IllegalArgumentException("Please enter a string consisting of multiple L and R");
			turns.add(c);
			boolean wasNew = colors.add(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			while( ! wasNew)
				wasNew = colors.add(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}

		return new Pattern(new ArrayList<>(colors), turns);
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
