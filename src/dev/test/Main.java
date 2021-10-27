package dev.test;

import dev.engine.rn.MSDisplay;
import dev.engine.rn.state.MSState;

public class Main {

	public static void main(String[] args) {
		new MSDisplay("test", 884, 522);
		MSState.SetState(new TestState());
	}

}
