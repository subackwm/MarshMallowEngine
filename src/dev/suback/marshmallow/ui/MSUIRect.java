package dev.suback.marshmallow.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import dev.suback.marshmallow.object.MSObject;

public class MSUIRect extends MSUI {

	public MSUIRect(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void engineRender(Graphics g) {
		if (this instanceof MSObject) {

			Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(pColor);

			float renderX = (int) position.GetX() - GetWidth() / 2, renderY = (int) position.GetY() - GetHeight() / 2;

			g2d.fillRect((int) renderX, (int) renderY, GetWidth(), GetHeight());

		} else
			System.out.println("error : you can't override this method!");
	}

}
