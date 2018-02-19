package org.ljrobotics.lib.util.drivers;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Accelerometer {

	private BuiltInAccelerometer accelerometer;
	
	public Accelerometer() {
		this.accelerometer = new BuiltInAccelerometer();
	}
	
	public double getX() {
		return this.accelerometer.getX();
	}
	
	public double getY() {
		return this.accelerometer.getY();
	}
	
	public double getZ() {
		return this.accelerometer.getZ();
	}
	
}
