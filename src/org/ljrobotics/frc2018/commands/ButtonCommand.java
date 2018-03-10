package org.ljrobotics.frc2018.commands;

import org.ljrobotics.frc2018.subsystems.Arm;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ButtonCommand extends InstantCommand {
	private JoystickButton button;
	private Command command;
	private boolean onFalse;
	
	/**
	 * Creates a new command that will execute another command conditionally based on a button input
	 * @param button the button to use as input
	 * @param command the command to run if desired
	 * @param onFalse whether to trigger on false or true
	 */
	public ButtonCommand(JoystickButton button, Command command, boolean onFalse) {
		this.button = button;
		this.command = command;
		this.onFalse = onFalse;
	}

	@Override
	protected void execute() {
		if(button.get() ^ onFalse) {
			Scheduler.getInstance().add(command);
		}
	}

}
