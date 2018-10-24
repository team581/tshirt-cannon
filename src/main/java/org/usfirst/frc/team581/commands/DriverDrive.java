package org.usfirst.frc.team581.commands;

import org.usfirst.frc.team581.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriverDrive extends Command{

	public DriverDrive() {
		// TODO Auto-generated constructor stub
		requires(Robot.drive);

	}
	protected void execute(){
		Robot.drive.driveWithJoysticks(Robot.oi.getLeftJoy(), Robot.oi.getRightJoy());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void initialize() {
		//Robot.drive.tankDrive(Robot.oi.leftJoy, Robot.drive.right);
		
	}
	
	protected void end() {
		
		//Robot.drive.stop();
	}

	
	protected void interrupted() {
		//end();
	}

}
