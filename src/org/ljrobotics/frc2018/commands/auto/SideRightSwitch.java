package org.ljrobotics.frc2018.commands.auto;

import org.ljrobotics.frc2018.commands.ArmSetpoint;
import org.ljrobotics.frc2018.commands.DriveForward;
import org.ljrobotics.frc2018.commands.FollowPath;
import org.ljrobotics.frc2018.commands.IntakeIdle;
import org.ljrobotics.frc2018.commands.IntakeSpitSlow;
import org.ljrobotics.frc2018.commands.ResetToPathHead;
import org.ljrobotics.frc2018.commands.TurnToAngle;
import org.ljrobotics.frc2018.commands.WaitSecond;
import org.ljrobotics.frc2018.commands.ZeroArm;
import org.ljrobotics.frc2018.paths.RightSideSwitch;
import org.ljrobotics.frc2018.subsystems.Arm;
import org.ljrobotics.lib.util.control.PathContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideRightSwitch extends CommandGroup{

	public SideRightSwitch(double endingAngle) {
		PathContainer path = new RightSideSwitch();
		this.addParallel(new ZeroArm());
		this.addSequential(new ResetToPathHead(path));
		this.addSequential(new ArmSetpoint(Arm.ArmPosition.INTAKE));
		this.addSequential(new WaitSecond(100));
		this.addSequential(new ArmSetpoint(Arm.ArmPosition.SWITCH));
		this.addSequential(new WaitSecond(500));
		this.addSequential(new FollowPath(path));
		this.addSequential(new TurnToAngle(endingAngle));
		this.addSequential(new DriveForward(0.3, 3));
		this.addSequential(new IntakeSpitSlow());
		this.addSequential(new WaitSecond(1000));
		this.addSequential(new IntakeIdle());
		this.addSequential(new DriveForward(-0.2, 0.5));
		this.addSequential(new ArmSetpoint(Arm.ArmPosition.INTAKE));
	}
	
}
