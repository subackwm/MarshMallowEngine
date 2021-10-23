package dev.engine.rn.object.shape;

import java.awt.Graphics;

public class MSRect extends MSShape {

	public MSRect(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
		g2d.setColor(pColor);
		g2d.fillRect(renderX, renderY, width, height);
	}

}
