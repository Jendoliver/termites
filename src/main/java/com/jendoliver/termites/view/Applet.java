package com.jendoliver.termites.view;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.jendoliver.termites.model.AntBasic;
import com.jendoliver.termites.model.Board;
import com.jendoliver.termites.properties.ApplicationProperties;

public class Applet extends JFrame
{
	private static final long serialVersionUID = -5394243480622310600L;
	private static final Logger logger = Logger.getLogger(Applet.class);

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 1000;

	private JPanel contentPane;
	private Renderer renderer;
	private AntControlPanel controlPanel;

	private static int refreshRate = 1;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Applet applet = new Applet(ApplicationProperties.getTitle());
					applet.setVisible(true);
					Timer timer = new Timer();
					timer.scheduleAtFixedRate(new TimerTask()
					{
						@Override
						public void run()
						{
							applet.renderer.repaint();
							applet.controlPanel.getAnt().step();
						}
					}, refreshRate, refreshRate);
				}
				catch (Exception e)
				{
					logger.debug(e.getMessage());
				}
			}
		});
	}

	private Applet(String title)
	{
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 1036);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		renderer = new RendererPure(
				new Board(
						Renderer.WINDOW_WIDTH / RendererPure.getCellSize(),
						Renderer.WINDOW_HEIGHT / RendererPure.getCellSize()));
		renderer.setBounds(5, 5, 1174, 851);
		contentPane.add(renderer);

		controlPanel = new AntControlPanel(new AntBasic(renderer.board));
		controlPanel.setBounds(5, 855, 1174, 149);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
	}

	public static int getRefreshRate()
	{
		return refreshRate;
	}

	public static void setRefreshRate(int refreshRate)
	{
		Applet.refreshRate = refreshRate;
	}
}
