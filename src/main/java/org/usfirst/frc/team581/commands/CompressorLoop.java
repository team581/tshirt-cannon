package org.usfirst.frc.team581.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team581.robot.Robot;

public class CompressorLoop extends Command {

  public CompressorLoop() {
    requires(Robot.pneumatics);
  }

  protected void execute() {
    Robot.pneumatics.compressorLoop();
  }

  @Override
  protected boolean isFinished() {
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
