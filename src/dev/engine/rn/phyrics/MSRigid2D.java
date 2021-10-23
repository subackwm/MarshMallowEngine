package dev.engine.rn.phyrics;

import dev.engine.rn.object.MSObject;

public class MSRigid2D {

	private float gValocity = 0f;
	private float gravity = 1f;

	private MSObject object;

	public MSRigid2D(MSObject object) {
		this.object = object;
	}

	public float GetGravity() {
		return gravity;
	}

	public void SetGravity(float gravity) {
		this.gravity = gravity;
	}

	public void rigidUpdate() {
		gValocity += gravity / 100;
		object.position.Translate(0, gValocity);
	}

}
