package dev.engine.rn.image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import dev.engine.rn.resource.MSResource;

public class MSSprite {

    private BufferedImage image;

    public MSSprite(String path) {
	image = new MSResource().GetImage(path);
    }

    public BufferedImage GetImage() {
	return image;
    }

    public void SetImage(BufferedImage image) {
	this.image = image;
    }

    public BufferedImage CutImage(int x, int y, int w, int h) {
	BufferedImage cutImage = Clone();
	return cutImage.getSubimage(x, y, w, h);
    }

    public BufferedImage Clone() {
	ColorModel cm = image.getColorModel();
	boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
	WritableRaster raster = image.copyData(null);
	return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}
