package dev.suback.marshmallow.transform;

public class MSTrans {

	private double x, y, z;

	public MSTrans(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public MSTrans(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double GetX() {
		return x;
	}

	public double GetY() {
		return y;
	}

	public double GetZ() {
		return z;
	}

	public void SetX(double x) {
		this.x = x;
	}

	public void SetY(double y) {
		this.y = y;
	}

	public void SetZ(double z) {
		this.z = z;
	}

	public void SetTransform(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void SetTransform(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void Translate(double xv, double yv) {
		this.x += xv;
		this.y += yv;
	}

	public void Translate(double xv, double yv, double zv) {
		this.x += xv;
		this.y += yv;
		this.z += zv;
	}

}
