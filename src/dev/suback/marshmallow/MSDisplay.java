package dev.suback.marshmallow;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class MSDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int width, height;
	public static String title;
	public static MSMain compo;

	public MSDisplay(String title, int width, int height) {

		MSDisplay.title = title;
		MSDisplay.width = width;
		MSDisplay.height = height;

		compo = new MSMain();
		compo.setPreferredSize(new Dimension(width, height));
		compo.setMaximumSize(new Dimension(width, height));
		compo.setMinimumSize(new Dimension(width, height));

		add(compo);
		pack();

		setMaximizedBounds(new Rectangle(width, height));
		setTitle(title);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(true);
	}

}
