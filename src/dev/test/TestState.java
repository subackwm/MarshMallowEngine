package dev.test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.engine.rn.camera.MSCamera;
import dev.engine.rn.input.MSInput;
import dev.engine.rn.state.MSState;

public class TestState implements MSState {

	public static ArrayList<TestObject> objs = new ArrayList<>();

	@Override
	public void Init() {
//		for (int i = 0; i < 200; i++)
//			for (int j = 0; j < 200; j++)
		objs.add(new TestObject(20 * 20, 10 * 20, 40, 40));
	}

	@Override
	public void Update() {
		if (MSInput.keys[KeyEvent.VK_SPACE]) {
//			MSCamera.position.Translate(0, 0, 0.025f);
			MSCamera.rotation += 0.025f;
		}
		for (int i = 0; i < objs.size(); i++) {
			objs.get(i).Update();
		}
	}

	@Override
	public void Render() {
		for (int i = 0; i < objs.size(); i++) {
			objs.get(i).Render();
		}
	}

}
