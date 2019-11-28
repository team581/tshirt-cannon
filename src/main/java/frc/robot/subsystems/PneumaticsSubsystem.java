/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;

/**
 * Pneumatics subsystem.
 * Handles compressed air, mainly just solenoids.
 */
public class PneumaticsSubsystem extends Subsystem {
  /** The firing mechanism double solenoid. */
  public final DoubleSolenoid firingMechanism = new DoubleSolenoid(
    RobotMap.firingMechanism.forward,
    RobotMap.firingMechanism.reverse
  );

  /** The double solenoid that controls the plunger used to load t-shirts. */
  public final DoubleSolenoid plunger = new DoubleSolenoid(RobotMap.plunger.forward, RobotMap.plunger.reverse);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  }
}
