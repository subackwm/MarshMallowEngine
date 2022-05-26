package dev.suback.marshmallow.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import dev.suback.marshmallow.MSDisplay;
import dev.suback.marshmallow.camera.MSCamera;
import dev.suback.marshmallow.math.MSMath;
import dev.suback.marshmallow.transform.MSTrans;

public class MSInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	public static boolean keys[] = new boolean[KeyEvent.KEY_LAST];
	public static int mouseScrollType;
	public static MSTrans mousePointer = new MSTrans(0, 0);
	public static MSTrans mousePointerMaster = new MSTrans(0, 0);
	public static MSTrans screenMousePointer = new MSTrans(0, 0);
	public static boolean mouseLeft, mouseRight, mouseCenter;

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePointer.SetX(e.getX());
		mousePointer.SetY(e.getY());
	}

	public static void setMasterMouse() {
		int Width = MSDisplay.width, Height = MSDisplay.height;

		double _dist = MSMath.GetDistance(
				new MSTrans(Width / 2, Height / 2),
				new MSTrans(mousePointer.GetX(), mousePointer.GetY()));
		double _rot = Math.atan2(Height / 2 - mousePointer.GetY(),
				Width / 2 - mousePointer.GetX()) - MSCamera.rotation;

		double xx = (mousePointer.GetX() - (Width / 2 + MSCamera.position.GetX()));
		double yy = (mousePointer.GetY() - (Height / 2 + MSCamera.position.GetY()));
		double _zDist = _dist / (MSCamera.position.GetZ());

		double _zx = (Math.cos(_rot) * _zDist), _zy = (Math.sin(_rot) * _zDist);

		mousePointerMaster.SetX((mousePointer.GetX() - (xx + _zx)));
		mousePointerMaster.SetY((mousePointer.GetY() - (yy + _zy)));

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePointer.SetX(e.getX());
		mousePointer.SetY(e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseLeft = true;
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			mouseCenter = true;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			mouseRight = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			mouseLeft = false;
		}
		if (e.getButton() == MouseEvent.BUTTON2) {
			mouseCenter = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			mouseRight = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			keys[e.getKeyCode()] = true;
		} catch (Exception f) {
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			keys[e.getKeyCode()] = false;
		} catch (Exception f) {
		}
	}

	public static void update() {
		setMasterMouse();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseScrollType = (int) e.getPreciseWheelRotation();
	}
}
