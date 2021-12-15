package com.engine.mm.ui;

import java.awt.event.MouseEvent;

import com.engine.mm.input.MSInput;

public class MSButton extends MSUI {

	private boolean onMouse = false;

	public MSButton(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void Update() {
		onMouse = false;
		if ((position.GetX() - GetWidth() / 2) <= MSInput.mousePointer.GetX()
				&& (position.GetX() + GetWidth() / 2) >= MSInput.mousePointer.GetX()) {
			if ((position.GetY() - GetHeight() / 2) <= MSInput.mousePointer.GetY()
					&& (position.GetY() + GetHeight() / 2) >= MSInput.mousePointer.GetY()) {
				onMouse = true;
				if (MSInput.mouseLeft) {
					OnClick(MouseEvent.BUTTON1);
					MSInput.mouseLeft = false;
				}
				if (MSInput.mouseCenter) {
					OnClick(MouseEvent.BUTTON2);
					MSInput.mouseCenter = false;
				}
				if (MSInput.mouseRight) {
					OnClick(MouseEvent.BUTTON3);
					MSInput.mouseRight = false;
				}
			}
		}
	}

	public void OnClick(int button) {
	}

	public boolean IsOnMouse() {
		return onMouse;
	}

}
