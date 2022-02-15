package dev.suback.marshmallow.object.shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.suback.marshmallow.camera.MSCamera;
import dev.suback.marshmallow.image.MSSprite;
import dev.suback.marshmallow.math.MSMath;
import dev.suback.marshmallow.object.MSObject;
import dev.suback.marshmallow.transform.MSTrans;
import dev.suback.marshmallow.ui.MSUI;

import dev.suback.marshmallow.MSDisplay;
import dev.suback.marshmallow.MSMain;

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

	public static final void RenderRect(int x, int y, double z, int width, int height) {
		MSRect rect = new MSRect(x, y, width, height);
		rect.position.SetZ(z);
		MSMain.renderObjects.add(rect);
	}

	public static final void RenderOval(int x, int y, int width, int height) {
		MSOval oval = new MSOval(x, y, width, height);
		oval.position.SetZ(2f);
		MSMain.renderObjects.add(oval);
	}

	public static final void RenderOval(int x, int y, double z, int width, int height) {
		MSOval oval = new MSOval(x, y, width, height);
		oval.position.SetZ(z);
		MSMain.renderObjects.add(oval);
	}

	public static final void RenderImage(MSSprite sprite, int x, int y, int width, int height) {
		MSImage image = new MSImage(sprite, x, y, width, height);
		image.position.SetZ(2f);
		MSMain.renderObjects.add(image);
	}

	public static final void RenderImage(MSSprite sprite, int x, int y, double z, int width, int height) {
		MSImage image = new MSImage(sprite, x, y, width, height);
		image.position.SetZ(z);
		MSMain.renderObjects.add(image);
	}

	public static final void RenderText(String text, int x, int y) {
		MSText tex = new MSText(text, x, y);
		tex.position.SetZ(2f);
		MSMain.renderObjects.add(tex);
	}

	public static final void RenderText(String text, int x, int y, double z) {
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

	public static final void RenderRect(MSRect rect) {
		MSMain.renderObjects.add(rect);
	}

	public static final void RenderRect(MSOval oval) {
		MSMain.renderObjects.add(oval);
	}

	public static final void RenderUI(MSUI ui) {
		MSMain.renderObjects.add(ui);
	}

	@Override
	public void engineRender(Graphics g) {
		if (this instanceof MSObject) {

			double fx = 1, fy = 1;
			int Width = MSDisplay.width, Height = MSDisplay.height;

			renderWidth = GetWidth() * MSCamera.position.GetZ();
			renderHeight = GetHeight() * MSCamera.position.GetZ();

			double _ww = this.renderWidth / 2;
			double _hh = this.renderHeight / 2;

			if (IsFlipX()) {
				fx = -1;
				_ww *= -1;
			}

			if (IsFlipY()) {
				fy = -1;
				_hh *= -1;
			}

			this.renderWidth *= fx;
			this.renderHeight *= fy;

			double _dist = MSMath.GetDistance(
					new MSTrans(Width / 2 + MSCamera.position.GetX(), Height / 2 + MSCamera.position.GetY()),
					new MSTrans(this.position.GetX(), this.position.GetY()));
			double _rot = Math.atan2(Height / 2 + MSCamera.position.GetY() - this.position.GetY(),
					Width / 2 + MSCamera.position.GetX() - this.position.GetX()) + MSCamera.rotation;
			double xx = (this.position.GetX() - (Width / 2 + MSCamera.position.GetX()));
			double yy = (this.position.GetY() - (Height / 2 + MSCamera.position.GetY()));
			double _zDist = _dist * (MSCamera.position.GetZ());

			double _zx = (Math.cos(_rot) * _zDist), _zy = (Math.sin(_rot) * _zDist);

			this.renderPosition.SetX((float) (this.position.GetX() - MSCamera.position.GetX() - _ww - (xx + _zx)));
			this.renderPosition.SetY((float) (this.position.GetY() - MSCamera.position.GetY() - _hh - (yy + _zy)));

			double _lS = GetWidth();
			if (GetWidth() < GetHeight())
				_lS = GetHeight();
			double _lsS = MSDisplay.width;
			if (MSDisplay.width < MSDisplay.height)
				_lsS = MSDisplay.height;

			this.isRender = true;
			if (MSMath.GetDistance(this.renderPosition, new MSTrans(MSDisplay.width / 2, MSDisplay.height / 2)) >= _lS
					+ _lsS) {
				this.isRender = false;
				return;
			}

			Graphics2D g2d = (Graphics2D) g;

			AffineTransform backup = g2d.getTransform();

			AffineTransform a = new AffineTransform();

			a.translate(this.renderPosition.GetX(), this.renderPosition.GetY());

			a.rotate(GetRotation() + MSCamera.rotation, this.renderWidth * GetAnchor().GetX(),
					this.renderHeight * GetAnchor().GetY());

			g2d.setTransform(a);

			this.renderShape(g2d, 0, 0, (int) renderWidth, (int) renderHeight);

			g2d.setTransform(backup);

		} else
			System.out.println("error : you can't override this method!");
	}

}
