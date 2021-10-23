package dev.engine.rn.transform;

public class MSTrans {

	private float x, y, z;

	public MSTrans(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public MSTrans(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float GetX() {
		return x;
	}

	public float GetY() {
		return y;
	}

	public float GetZ() {
		return z;
	}

	public void SetX(float x) {
		this.x = x;
	}

	public void SetY(float y) {
		this.y = y;
	}

	public void SetZ(float z) {
		this.z = z;
	}

	public void SetTransform(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void SetTransform(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void Translate(float xv, float yv) {
		this.x += xv;
		this.y += yv;
	}

	public void Translate(float xv, float yv, float zv) {
		this.x += xv;
		this.y += yv;
		this.z += zv;
	}

}
