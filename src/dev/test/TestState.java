package dev.test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.engine.rn.MSDisplay;
import dev.engine.rn.camera.MSCamera;
import dev.engine.rn.input.MSInput;
import dev.engine.rn.state.MSState;

public class TestState implements MSState {

	public static ArrayList<TestObject> objs = new ArrayList<>();

	@Override
	public void Init() {
		for (int i = 0; i < 20; i++)
			objs.add(new TestObject(100 + i * 80, MSDisplay.height / 2, 80, 80));
	}

	@Override
	public void Update() {
		if (MSInput.keys[KeyEvent.VK_SPACE]) {
			MSCamera.position.Translate(0, 0, 0.025f);
			MSCamera.rotation += 0.025f;
			int renderCount = 0;
			for (int i = 0; i < objs.size(); i++) {
				if(objs.get(i).IsRendering())
					renderCount++;
				objs.get(i).Rotate(0.25f);
			}
			
			System.out.println(renderCount);
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
