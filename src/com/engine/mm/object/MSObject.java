package com.engine.mm.object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import com.engine.mm.MSDisplay;
import com.engine.mm.MSMain;
import com.engine.mm.camera.MSCamera;
import com.engine.mm.image.MSSprite;
import com.engine.mm.math.MSMath;
import com.engine.mm.transform.MSTrans;

public class MSObject implements Comparable<MSObject> {

	public MSTrans position;
	public MSTrans renderPosition;
	public double renderWidth, renderHeight;
	private int width, height;
	private MSSprite sprite;
	protected boolean flipX, flipY, isRender;
	private float rotation = 0f;
	private MSTrans anchor;
	private BufferedImage backUpSprite;
	private boolean visible = true;

	public MSObject(int x, int y, int width, int height) {
		position = new MSTrans(x, y, 1f);
		renderPosition = new MSTrans(x, y, 1f);
		anchor = new MSTrans(0.5f, 0.5f);
		this.width = width;
		this.height = height;
	}

	public final void CreateMaterial() {
		if (sprite == null) {
			System.out.println("error : the sprite is null!");
			return;
		}
		backUpSprite = sprite.Clone();
	}

	public final MSTrans GetAnchor() {
		return anchor;
	}

	public final void SetAnchor(MSTrans anchor) {
		this.anchor = anchor;
	}

	public final float GetRotation() {
		return rotation;
	}

	public final void SetRotation(float rotation) {
		this.rotation = rotation;
	}

	public final void Rotate(float rotation) {
		this.rotation += rotation;
	}

	public final MSSprite GetSprite() {
		if (sprite != null)
			return sprite;
		else
			return null;
	}

	public void Update() {
	}

	public void Render() {
		MSMain.renderObjects.add(this);
	}

	protected boolean inScreen = false;

	public final boolean GetInScreen() {
		return inScreen;
	}

	public void engineRender(Graphics g) {
		if (!visible)
			return;

		if (this instanceof MSObject) {
			double fx = 1, fy = 1;
			int Width = MSDisplay.width, Height = MSDisplay.height;

			renderWidth = width * MSCamera.position.GetZ();
			renderHeight = height * MSCamera.position.GetZ();

			double _ww = this.renderWidth / 2;
			double _hh = this.renderHeight / 2;

			if (this.flipX) {
				fx = -1;
				_ww *= -1;
			}

			if (this.flipY) {
				fy = -1;
				_hh *= -1;
			}

			this.renderWidth *= (fx);
			this.renderHeight *= (fy);

			double _dist = MSMath.GetDistance(
					new MSTrans(Width / 2 + MSCamera.position.GetX(), Height / 2 + MSCamera.position.GetY()),
					new MSTrans(this.position.GetX(), this.position.GetY()));
			double _rot = Math.atan2(Height / 2 + MSCamera.position.GetY() - this.position.GetY(),
					Width / 2 + MSCamera.position.GetX() - this.position.GetX()) + MSCamera.rotation;
			double xx = (this.position.GetX() - (Width / 2 + MSCamera.position.GetX()));
			double yy = (this.position.GetY() - (Height / 2 + MSCamera.position.GetY()));
			double _zDist = _dist * (MSCamera.position.GetZ());

			double _zx = (Math.cos(_rot) * _zDist), _zy = (Math.sin(_rot) * _zDist);

			this.renderPosition.SetX((this.position.GetX() - MSCamera.position.GetX() - _ww - (xx + _zx)));
			this.renderPosition.SetY((this.position.GetY() - MSCamera.position.GetY() - _hh - (yy + _zy)));

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

			a.rotate(this.rotation + MSCamera.rotation, this.renderWidth * anchor.GetX(),
					this.renderHeight * anchor.GetY());

			g2d.setTransform(a);

			if (sprite != null)
				g2d.drawImage(sprite.GetImage(), 0, 0, (int) renderWidth, (int) renderHeight, null);

			g2d.setTransform(backup);

		} else
			System.out.println("error : you can't override this method!");
	}

	public final void SetSprite(MSSprite sprite) {
		this.sprite = sprite;
	}

	public final int GetWidth() {
		return width;
	}

	public final int GetHeight() {
		return height;
	}

	public final void SetSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public final void SetWidth(int width) {
		this.width = width;
	}

	public final void SetHeight(int height) {
		this.width = height;
	}

	public final boolean IsFlipX() {
		return flipX;
	}

	public final void SetFlipX(boolean flipX) {
		this.flipX = flipX;
	}

	public final boolean IsFlipY() {
		return flipY;
	}

	public final void SetFlipY(boolean flipY) {
		this.flipY = flipY;
	}

	public final BufferedImage getBackupSprite() {
		return backUpSprite;
	}

	public final boolean IsRendering() {
		return isRender;
	}

	public final boolean IsVisible() {
		return visible;
	}

	public final void SetVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public int compareTo(MSObject o) {
		if (this.position.GetZ() < o.position.GetZ()) {
			return -1;
		} else if (this.position.GetZ() == o.position.GetZ()) {
			return 0;
		} else {
			return 1;
		}
	}
}
