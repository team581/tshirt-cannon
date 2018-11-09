package org.usfirst.frc.team581.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team581.robot.Robot;

public class DriverDrive extends Command {

  public DriverDrive() {
    requires(Robot.drive);
  }

  protected void execute() {
    Robot.drive.driveWithJoysticks(
        Robot.driverControl.getLeftJoy(), Robot.driverControl.getRightJoy()
    );
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  protected void initialize() {
    // Robot.drive.tankDrive(Robot.driverControl.leftJoy, Robot.drive.right);
  }

  protected void end() {
    // Robot.drive.stop();
  }

  protected void interrupted() {
    // end();
  }

}
