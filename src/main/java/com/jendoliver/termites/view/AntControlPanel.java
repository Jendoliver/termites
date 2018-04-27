package com.jendoliver.termites.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.jendoliver.termites.factory.PatternFactory;
import com.jendoliver.termites.model.AntAlgorithm;
import com.jendoliver.termites.model.AntBasic;
import com.jendoliver.termites.properties.ApplicationProperties;

public class AntControlPanel extends JPanel
{
	private transient AntBasic ant;

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 150;

	public AntControlPanel(AntBasic ant)
	{
		this.ant = ant;

		setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

		setLayout(null);

		JLabel lblPattern = new JLabel("Pattern properties");
		lblPattern.setFont(new Font("Yu Gothic UI", Font.PLAIN, 25));
		lblPattern.setBounds(37, 11, 220, 34);
		add(lblPattern);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(300, 11, 2, 128);
		add(separator);

		JButton btnSimulate = new JButton("SIMULATE");
		btnSimulate.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				ant.setPatternAndRestart(PatternFactory.createFromString(turnsPattern.getText()));
			}
		});
		btnSimulate.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnSimulate.setBounds(867, 23, 190, 95);
		add(btnSimulate);

		JLabel lblRenderProperties = new JLabel("Render properties");
		lblRenderProperties.setFont(new Font("Yu Gothic UI", Font.PLAIN, 25));
		lblRenderProperties.setBounds(350, 11, 220, 34);
		add(lblRenderProperties);

		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(607, 11, 2, 128);
		add(separator2);

		JSpinner msBetweenFrames = new JSpinner();
		msBetweenFrames.setModel(new SpinnerNumberModel(1, 0, 1000, 1));
		msBetweenFrames.setBounds(480, 56, 90, 20);
		add(msBetweenFrames);

		JButton btnRandomize = new JButton("RANDOMIZE");
		btnRandomize.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				ant.setPatternAndRestart(PatternFactory.createRandom(ApplicationProperties.getMaxPatternSize()));
				Applet.setRefreshRate((int)msBetweenFrames.getValue());

			}
		});
		btnRandomize.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btnRandomize.setBounds(644, 23, 190, 95);
		add(btnRandomize);

		JLabel lblTurns = new JLabel("Turns:");
		lblTurns.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblTurns.setBounds(25, 56, 46, 14);
		add(lblTurns);

		turnsPattern = new JTextField();
		turnsPattern.setToolTipText("The turn direction associated with each color");
		turnsPattern.setText("LR");
		turnsPattern.setBounds(81, 56, 176, 20);
		add(turnsPattern);
		turnsPattern.setColumns(10);

		JLabel lblColors = new JLabel("Colors:");
		lblColors.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblColors.setBounds(25, 98, 46, 14);
		add(lblColors);

		JLabel lblNewLabel = new JLabel("TBA");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(131, 104, 46, 14);
		add(lblNewLabel);

		JLabel lblMsBetweenFrames = new JLabel("Ms between frames:");
		lblMsBetweenFrames.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblMsBetweenFrames.setBounds(320, 56, 150, 14);
		add(lblMsBetweenFrames);

		JLabel lblRenderingStyle = new JLabel("Rendering style:");
		lblRenderingStyle.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblRenderingStyle.setBounds(320, 88, 150, 34);
		add(lblRenderingStyle);

		JLabel label = new JLabel("TBA");
		label.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(503, 101, 46, 14);
		add(label);
	}

	public AntAlgorithm getAnt()
	{
		return ant;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		ant.step();
	}

	private static final long serialVersionUID = -4599168160421446298L;
	private JTextField turnsPattern;
}
