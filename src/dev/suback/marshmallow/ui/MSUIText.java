package dev.suback.marshmallow.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.suback.marshmallow.object.MSObject;

public class MSUIText extends MSUI {

	public String str;

	public MSUIText(String string, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.str = string;
	}

	@Override
	public void engineRender(Graphics g) {
		if (this instanceof MSObject) {

			Graphics2D g2d = (Graphics2D) g;
			
			AffineTransform backup = g2d.getTransform();

			float renderX = (int) position.GetX() - GetWidth() / 2, renderY = (int) position.GetY() - GetHeight() / 2;

			FontMetrics fm = g2d.getFontMetrics();
			int w = (int) (renderX * 2);
			int h = (int) (renderY * 2);
			int _x = (w - fm.stringWidth(str)) / 2;
			int _y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);

			g2d.drawString(str, renderX + _x, renderY + _y);

			g2d.setTransform(backup);

		} else
			System.out.println("error : you can't override this method!");
	}
}
