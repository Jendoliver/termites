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
import com.jendoliver.termites.model.Pattern;
import com.jendoliver.termites.properties.ApplicationProperties;

public class AntControlPanel extends JPanel
{
	private static final String YU_GOTHIC_UI = "Yu Gothic UI";

	private transient AntBasic ant;

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 150;

	JSpinner msBetweenFrames;
	JSpinner cellSize;

	public AntControlPanel(AntBasic ant)
	{
		this.ant = ant;

		setSize(new Dimension(1200, 120));

		setLayout(null);

		JLabel lblPattern = new JLabel("Pattern properties");
		lblPattern.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblPattern.setBounds(63, 0, 176, 34);
		add(lblPattern);

		msBetweenFrames = new JSpinner();
		msBetweenFrames.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		msBetweenFrames.setBounds(480, 34, 90, 14);
		add(msBetweenFrames);

		JLabel lblRenderProperties = new JLabel("Render properties");
		lblRenderProperties.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblRenderProperties.setBounds(364, 0, 220, 34);
		add(lblRenderProperties);

		JButton btnRandomize = new JButton("RANDOMIZE");
		btnRandomize.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				regenerateScene(PatternFactory.createRandom(ApplicationProperties.getMaxPatternSize()));
			}
		});

		JButton btnSimulate = new JButton("SIMULATE");
		btnSimulate.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				regenerateScene(PatternFactory.createFromString(turnsPattern.getText()));
			}
		});

		btnRandomize.setFont(new Font(YU_GOTHIC_UI, Font.BOLD, 20));
		btnRandomize.setBounds(963, 22, 190, 35);
		add(btnRandomize);

		btnSimulate.setFont(new Font(YU_GOTHIC_UI, Font.BOLD, 20));
		btnSimulate.setBounds(963, 68, 190, 34);
		add(btnSimulate);

		JLabel lblTurns = new JLabel("Turns:");
		lblTurns.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblTurns.setBounds(25, 43, 46, 14);
		add(lblTurns);

		turnsPattern = new JTextField();
		turnsPattern.setToolTipText("The turn direction associated with each color");
		turnsPattern.setText("LR");
		turnsPattern.setBounds(84, 45, 176, 18);
		add(turnsPattern);
		turnsPattern.setColumns(10);

		JLabel lblColors = new JLabel("Colors:");
		lblColors.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblColors.setBounds(25, 74, 46, 14);
		add(lblColors);

		JLabel lblNewLabel = new JLabel("TBA");
		lblNewLabel.setFont(new Font(YU_GOTHIC_UI, Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(232, 75, 46, 14);
		add(lblNewLabel);

		JLabel lblMsBetweenFrames = new JLabel("Ms between frames:");
		lblMsBetweenFrames.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblMsBetweenFrames.setBounds(320, 34, 150, 14);
		add(lblMsBetweenFrames);

		JLabel lblRenderingStyle = new JLabel("Rendering style:");
		lblRenderingStyle.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblRenderingStyle.setBounds(320, 61, 150, 17);
		add(lblRenderingStyle);

		JLabel label = new JLabel("TBA");
		label.setFont(new Font(YU_GOTHIC_UI, Font.BOLD | Font.ITALIC, 13));
		label.setBounds(525, 62, 46, 14);
		add(label);

		JLabel lblCellSize = new JLabel("Cell size:");
		lblCellSize.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblCellSize.setBounds(320, 86, 150, 16);
		add(lblCellSize);

		JSeparator separator3 = new JSeparator();
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setBounds(918, 11, 2, 97);
		add(separator3);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(626, 11, 2, 97);
		add(separator);

		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(283, 15, 2, 97);
		add(separator2);

		cellSize = new JSpinner();
		cellSize.setModel(new SpinnerNumberModel(5, 1, 100, 1));
		cellSize.setBounds(480, 88, 90, 14);
		add(cellSize);
	}

	private void regenerateScene(Pattern pattern)
	{
		ant.setPatternAndRestart(pattern);
		turnsPattern.setText(ant.getPattern().toString());

		try
		{
			msBetweenFrames.commitEdit();
			cellSize.commitEdit();
			Applet.getInstance().setRefreshRate((Integer)msBetweenFrames.getValue());
		}
		catch (java.text.ParseException e) { /* Ignored */ }

		Applet.getInstance().getRenderer().setCellSize((Integer)cellSize.getValue());
		ant.spawnAtCenter();
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
