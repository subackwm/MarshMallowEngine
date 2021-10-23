package dev.engine.rn.phyrics.collider;

import dev.engine.rn.object.MSObject;

public class MSCollider {

	private MSObject object;
	private float x, y, width, height;

	public MSCollider(MSObject object) {
		this.object = object;
		this.x = object.position.GetX();
		this.y = object.position.GetY();
		this.width = object.GetWidth();
		this.height = object.GetHeight();
	}

	public final MSObject GetObject() {
		return object;
	}

	public final float GetX() {
		return x;
	}

	public final void SetX(float x) {
		this.x = x;
	}

	public final float GetY() {
		return y;
	}

	public final void SetY(float y) {
		this.y = y;
	}

	public final float GetWidth() {
		return width;
	}

	public final void SetWidth(float width) {
		this.width = width;
	}

	public final float GetHeight() {
		return height;
	}

	public final void SetHeight(float height) {
		this.height = height;
	}

}
