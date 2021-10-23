package dev.engine.rn.object.shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import dev.engine.rn.MSMain;
import dev.engine.rn.camera.MSCamera;
import dev.engine.rn.object.MSObject;

public class MSShape extends MSObject {

	protected Color pColor;
	protected Font pFont;

	public MSShape(int x, int y, int width, int height) {
		super(x, y, width, height);
		pColor = MSShape.color;
		pFont = MSShape.font;
	}

	public void renderShape(Graphics g2d, int renderX, int renderY, int width, int height) {
	}

	private static Color color = Color.black;
	private static Font font = null;

	public static final void SetFont(Font f) {
		font = f;
	}

	public static final void SetColor(Color c) {
		color = c;
	}

	public static final void RenderRect(int x, int y, int width, int height) {
		MSRect rect = new MSRect(x, y, width, height);
		rect.position.SetZ(2f);
		MSMain.renderObjects.add(rect);
	}

	public static final void RenderRect(int x, int y, float z, int width, int height) {
		MSRect rect = new MSRect(x, y, width, height);
		rect.position.SetZ(z);
		MSMain.renderObjects.add(rect);
	}

	public static final void RenderOval(int x, int y, int width, int height) {
		MSOval oval = new MSOval(x, y, width, height);
		oval.position.SetZ(2f);
		MSMain.renderObjects.add(oval);
	}

	public static final void RenderOval(int x, int y, float z, int width, int height) {
		MSOval oval = new MSOval(x, y, width, height);
		oval.position.SetZ(z);
		MSMain.renderObjects.add(oval);
	}

	public static final void RenderImage(BufferedImage sprite, int x, int y, int width, int height) {
		MSImage image = new MSImage(sprite, x, y, width, height);
		image.position.SetZ(2f);
		MSMain.renderObjects.add(image);
	}

	public static final void RenderImage(BufferedImage sprite, int x, int y, float z, int width, int height) {
		MSImage image = new MSImage(sprite, x, y, width, height);
		image.position.SetZ(z);
		MSMain.renderObjects.add(image);
	}

	public static final void RenderText(String text, int x, int y) {
		MSText tex = new MSText(text, x, y);
		tex.position.SetZ(2f);
		MSMain.renderObjects.add(tex);
	}

	public static final void RenderText(String text, int x, int y, float z) {
		MSText tex = new MSText(text, x, y);
		tex.position.SetZ(z);
		MSMain.renderObjects.add(tex);
	}

	public static final void RenderText(MSText tex) {
		MSMain.renderObjects.add(tex);
	}

	public static final void RenderImage(MSImage image) {
		MSMain.renderObjects.add(image);
	}

	public static final void RenderRect(MSImage rect) {
		MSMain.renderObjects.add(rect);
	}

	public static final void RenderRect(MSOval oval) {
		MSMain.renderObjects.add(oval);
	}

	@Override
	public void engineRender(Graphics g) {
//		engineUpdate();
		if (this instanceof MSObject) {
			if (material != null) {
				material.renderMaterial();
			}

			int xflip = 1, yflip = 1;

			if (IsFlipX())
				xflip = -1;
			if (IsFlipY())
				yflip = -1;

			Graphics2D g2d = (Graphics2D) g;

			AffineTransform backup = g2d.getTransform();

			float renderX = (int) position.GetX() - (GetWidth() / 2 * xflip) - (int) MSCamera.position.GetX(),
					renderY = (int) position.GetY() - (GetHeight() / 2 * yflip) - (int) MSCamera.position.GetY();

			AffineTransform a = AffineTransform.getRotateInstance(GetRotation(), renderX + GetAnchor().GetX() * xflip,
					renderY + GetAnchor().GetY() * yflip);

			g2d.setTransform(a);
			g2d.setColor(color);
			g2d.setFont(font);
			renderShape(g2d, (int) (renderX + MSCamera.position.GetX()), (int) (renderY + MSCamera.position.GetY()),
					GetWidth() * xflip, GetHeight() * yflip);
			g2d.setTransform(backup);

		} else
			System.out.println("error : you can't override this method!");
	}

}
