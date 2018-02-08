package org.usfirst.frc.team581.commands;

import org.usfirst.frc.team581.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

public class CompressorLoop extends Command{

	public CompressorLoop() {
		// TODO Auto-generated constructor stub
		requires(Robot.pneumatics);
	}
	protected void execute(){
		Robot.pneumatics.compressorLoop();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	 // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
