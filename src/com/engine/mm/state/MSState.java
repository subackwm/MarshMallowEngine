package com.engine.mm.state;

import com.engine.mm.MSMain;

public interface MSState {

	public void Init();

	public void Update();

	public void Render();

	public static void SetState(MSState state) {
		MSMain.renderObjects.clear();
		state.Init();
		MSMain.state = state;
	}

}
