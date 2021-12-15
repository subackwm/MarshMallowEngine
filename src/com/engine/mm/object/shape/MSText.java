package com.engine.mm.object.shape;

import java.awt.FontMetrics;
import java.awt.Graphics;

public class MSText extends MSShape {

	private String text;

	public MSText(String text, int x, int y) {
		super(x, y, 0, 0);
		this.text = text;
	}

	@Override
	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
		g2d.setColor(pColor);
		g2d.setFont(pFont);
		FontMetrics fm = g2d.getFontMetrics();
		int w = renderX * 2;
		int h = renderY * 2;
		int _x = (w - fm.stringWidth(text)) / 2;
		int _y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);

		g2d.drawString(text, renderX + _x, renderY + _y);

	}

}
