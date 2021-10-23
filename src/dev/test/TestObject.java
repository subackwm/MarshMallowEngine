package dev.test;

import dev.engine.rn.camera.MSCamera;
import dev.engine.rn.input.MSInput;
import dev.engine.rn.math.MSMath;
import dev.engine.rn.object.MSObject;
import dev.engine.rn.transform.MSTrans;

public class TestObject extends MSObject {

	public TestObject(int x, int y, int width, int height) {
		super(x, y, width, height);
		SetSprite(Asset.ms);
		position.SetZ(0);
	}

	@Override
	public void Update() {
		if (MSMath.GetDistance(
				new MSTrans((float) (this.renderPosition.GetX() + this.renderWidth / 2),
						(float) (this.renderPosition.GetY() + this.renderHeight / 2)),
				MSInput.mousePointer) <= this.GetWidth() * MSCamera.position.GetZ() / 4) {
			this.SetWidth(200);
			this.SetHeight(200);
		} else {
			this.SetWidth(100);
			this.SetHeight(100);
		}
	}

}
