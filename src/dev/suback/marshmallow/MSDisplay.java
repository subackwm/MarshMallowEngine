package dev.suback.marshmallow;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class MSDisplay extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int width, height;
	public static String title;
	public static MSMain compo;

	public MSDisplay(String title, int width, int height) {

		pack();
		MSDisplay.title = title;
		MSDisplay.width = width;
		MSDisplay.height = height;

		compo = new MSMain();
		compo.setMinimumSize(new Dimension(width, height));
		compo.setMaximumSize(new Dimension(width, height));
		compo.setPreferredSize(new Dimension(width, height));

		setMinimumSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));

		setTitle(title);
		setLayout(new BorderLayout());
		add(compo, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
