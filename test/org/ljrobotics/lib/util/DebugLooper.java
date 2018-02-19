package org.ljrobotics.lib.util;

import org.ljrobotics.frc2018.loops.Loop;
import org.ljrobotics.frc2018.loops.Looper;

public class DebugLooper extends Looper{

	private Loop loop;
	
	public DebugLooper() {
		super(true);
	}

	@Override
	public synchronized void register(Loop loop) {
		this.loop = loop;
	}
	
	public Loop getLoop() {
		return this.loop;
	}

}