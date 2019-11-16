/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import frc.robot.RobotMap;
import frc.robot.util.Colors;
import frc.robot.util.ShuffleboardUtil;
import java.util.Map;

/**
 * Pneumatics subsystem.
 * Handles compressed air, mainly just solenoids.
 */
public class PneumaticsSubsystem extends Subsystem {
  private NetworkTableEntry solenoidIndicator = ShuffleboardUtil
    .tab.add("Solenoid value", false)
    .withSize(1, 1)
    .withPosition(2, 3)
    .withWidget(BuiltInWidgets.kBooleanBox)
    .withProperties(Map.of("color when true", Colors.GREEN, "color when false", Colors.RED))
    .getEntry();

  /** The solenoid. */
  public final DoubleSolenoid solenoid = new DoubleSolenoid(
    RobotMap.doubleSolenoidForwardChannel,
    RobotMap.doubleSolenoidReverseChannel
 );

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    System.out.println("solenoid value rn: " + solenoid.get());
    System.out.println("is solenoid forward?: " + (solenoid.get() == Value.kForward));
    this.solenoidIndicator.setBoolean(solenoid.get() == Value.kForward);
  }
}
