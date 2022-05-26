package dev.suback.marshmallow.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.suback.marshmallow.object.MSObject;

public class MSUI extends MSObject {

	public MSUI(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void engineRender(Graphics g) {
		if (this instanceof MSObject) {

			int xflip = 1, yflip = 1;

			if (IsFlipX())
				xflip = -1;
			if (IsFlipY())
				yflip = -1;

			Graphics2D g2d = (Graphics2D) g;

			AffineTransform backup = g2d.getTransform();

			float renderX = (int) position.GetX() - GetWidth() / 2, renderY = (int) position.GetY() - GetHeight() / 2;
			
			AffineTransform a = AffineTransform.getRotateInstance(GetRotation(), renderX + GetAnchor().GetX() * xflip,
					renderY + GetAnchor().GetY() * yflip);

			g2d.setTransform(a);
			g2d.drawImage(GetSprite().GetImage(), (int) renderX, (int) renderY, GetWidth(), GetHeight(), null);
			g2d.setTransform(backup);

		} else
			System.out.println("error : you can't override this method!");
	}
}
