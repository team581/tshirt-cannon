package org.usfirst.frc.team581.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team581.commands.DriverDrive;
import org.usfirst.frc.team581.robot.RobotMap;

public class Drive extends Subsystem {

  public DifferentialDrive robotDrive;
  public Spark motorLeft = new Spark(RobotMap.leftMotor);
  public Spark motorRight = new Spark(RobotMap.rightMotor);

  public Drive() {

    robotDrive = new DifferentialDrive(motorLeft, motorRight);
  }

  /**
   * Set the default command for this class.
   */
  public void initDefaultCommand() {
    setDefaultCommand(new DriverDrive());
    // robotDrive.setExpiration(0.1);
    // stick = new Joystick(joystickChannel);
    // System.out.println("made Drive class");

  }

  public void driveWithJoysticks(double left, double right) {
    robotDrive.tankDrive(left, right);
    // System.out.println("--> Calling tankdrive and giving joysticks.");
  }

}
