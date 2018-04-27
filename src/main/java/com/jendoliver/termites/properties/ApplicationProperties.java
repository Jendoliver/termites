package com.jendoliver.termites.properties;

import java.util.ResourceBundle;

public final class ApplicationProperties
{
	private static String version;
	private static String name;
	private static int maxPatternSize;

	private ApplicationProperties()
	{
		throw new UnsupportedOperationException("ApplicationProperties must not be instantiated!");
	}

	static
	{
		ResourceBundle bundle = ResourceBundle
				.getBundle("com.jendoliver.termites.properties.application");

		version = bundle.getString("version");
		name = bundle.getString("name");
		maxPatternSize = Integer.parseInt(bundle.getString("maxPatternSize"));
	}

	public static String getVersion()
	{
		return version;
	}

	public static String getName()
	{
		return name;
	}

	public static String getTitle()
	{
		return name + " - v." + version;
	}

	public static int getMaxPatternSize()
	{
		return maxPatternSize;
	}
}
