package dev.suback.marshmallow.object.shape;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.suback.marshmallow.image.MSSprite;

public class MSImage extends MSShape {

	private BufferedImage sprite;

	public MSImage(BufferedImage sprite, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.sprite = sprite;
	}

	public MSImage(MSSprite sprite, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.sprite = sprite.GetImage();
	}

	@Override
	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
		g2d.drawImage(sprite, renderX, renderY, width, height, null);
	}

}
