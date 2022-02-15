package dev.suback.marshmallow.object.shape;

import java.awt.Graphics;

public class MSOval extends MSShape {

	public MSOval(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
		g2d.setColor(pColor);
		g2d.fillOval(renderX, renderY, width, height);
	}

}
