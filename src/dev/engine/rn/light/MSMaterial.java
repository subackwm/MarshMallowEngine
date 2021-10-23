package dev.engine.rn.light;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.engine.rn.camera.MSCamera;
import dev.engine.rn.input.MSInput;
import dev.engine.rn.math.MSMath;
import dev.engine.rn.object.MSObject;
import dev.engine.rn.transform.MSTrans;

public class MSMaterial {

	private MSObject object;

	public MSMaterial(MSObject object) {
		this.object = object;
	}

	public void renderMaterial() {

		if (object == null) {
			System.out.println("error : object is null");
			return;
		}

		object.GetSprite().SetImage(object.getBackupSprite());
		BufferedImage image = object.GetSprite().Clone();

		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				if (image.getRGB(i, j) != 0) {

					int _pws = (object.GetWidth() / image.getWidth());
					int _phs = (object.GetHeight() / image.getHeight());

					int _xx = (int) ((_pws * i) + (object.position.GetX() - object.GetWidth() / 2)
							- MSCamera.position.GetX());
					int _yy = (int) ((_phs * j) + (object.position.GetY() - object.GetHeight() / 2)
							- MSCamera.position.GetY());

					int dist = (int) MSMath.GetDistance(new MSTrans(_xx, _yy), MSInput.mousePointer);

					Color c = new Color(image.getRGB(i, j));

					int a = 255 - (10 - 5) * dist;

					if (a > 255)
						a = 255;
					if (a < 0)
						a = 0;

					int r = c.getRed(), g = c.getGreen(), b = c.getBlue();

					if (r > 255)
						r = 255;
					if (r < 0)
						r = 0;

					if (g > 255)
						g = 255;
					if (g < 0)
						g = 0;

					if (b > 255)
						b = 255;
					if (b < 0)
						b = 0;

					image.setRGB(i, j, new Color(r, g, b, a).getRGB());
				}
			}
		}

		object.GetSprite().SetImage(image);
	}

}
