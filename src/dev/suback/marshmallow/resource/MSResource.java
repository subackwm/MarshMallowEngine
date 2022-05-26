package dev.suback.marshmallow.resource;

import java.awt.Font;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class MSResource {

	public BufferedImage GetImage(String path) {
		try {
			return (ImageIO.read(getClass().getClassLoader().getResource(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Font GetFont(String path, float size) {
		InputStream stream;
		Font customFont = null;
		try {
			stream = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
			customFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(size);
		} catch (Exception e) {
			System.out.println("FONT ERROR");
		}
		return customFont;
	}

}
