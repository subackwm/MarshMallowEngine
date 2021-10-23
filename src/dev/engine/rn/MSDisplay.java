package dev.engine.rn;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MSDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int width, height;
	public static String title;

	public MSDisplay(String title, int width, int height) {

		MSDisplay.title = title;
		MSDisplay.width = width;
		MSDisplay.height = height;

		pack();
		add(new MSMain());
		setSize(new Dimension(width, height));
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
