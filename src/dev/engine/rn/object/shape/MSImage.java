package dev.engine.rn.object.shape;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MSImage extends MSShape {

	private BufferedImage sprite;

	public MSImage(BufferedImage sprite, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.sprite = sprite;
	}

	@Override
	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
		g2d.drawImage(sprite, renderX, renderY, width, height, null);
	}

}
