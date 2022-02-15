package dev.suback.marshmallow.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import dev.suback.marshmallow.resource.MSResource;

public class MSSprite {

	private BufferedImage image;

	public MSSprite(String path) {
		image = new MSResource().GetImage(path);
	}

	public MSSprite(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage GetImage() {
		return image;
	}

	public void SetImage(BufferedImage image) {
		this.image = image;
	}

	public MSSprite CutImage(int x, int y, int w, int h) {
		BufferedImage cutImage = Clone();
		return new MSSprite(cutImage.getSubimage(x, y, w, h));
	}

	public final BufferedImage Clone() {
		BufferedImage _result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				Color c = new Color(image.getRGB(i, j), true);

				if (c.getAlpha() != 0)
					_result.setRGB(i, j, image.getRGB(i, j));
				else
					_result.setRGB(i, j, new Color(0, 0, 0, 0).getRGB());
			}
		}

		return _result;
	}

}
